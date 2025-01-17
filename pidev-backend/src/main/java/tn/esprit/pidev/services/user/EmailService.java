package tn.esprit.pidev.services.user;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendConfirmationEmail(String to,String prenom,String nom, String username, String confirmationLink) {
        Context context = new Context();
        context.setVariable("prenom",prenom);
        context.setVariable("nom",nom);
        context.setVariable("username", username);
        context.setVariable("confirmationLink", confirmationLink);
        String htmlContent = templateEngine.process("confirmation-email", context);

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("Email Confirmation");
            helper.setText(htmlContent, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}

//    @Async
//    public void send(
//            String to,
//            String username,
//            String templateName,
//            String confirmationUrl
//    ) throws MessagingException {
//        if(!StringUtils.hasLength(templateName)) {
//            templateName = "confirm-email";
//        }
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(
//          mimeMessage,
//          MimeMessageHelper.MULTIPART_MODE_MIXED,
//                StandardCharsets.UTF_8.name()
//        );
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("username",username);
//        properties.put("confirmationUrl",confirmationUrl);
//        Context context = new Context();
//        context.setVariables(properties);
//        mimeMessageHelper.setFrom("sayf.abidi1@gmail.com");
//        mimeMessageHelper.setTo(to);
//        mimeMessageHelper.setSubject("Welcome to our community!");
//        String template = templateEngine.process(templateName,context);
//
//        mimeMessageHelper.setText(template, true);
//
//        javaMailSender.send(mimeMessage);
//    }

//}

