package tn.esprit.pidev.controller.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entities.chat.Reaction;
import tn.esprit.pidev.services.chat.IGestionReaction;

@RestController
@RequestMapping("/reaction")
public class ReactionController {
    @Autowired
    IGestionReaction iGestionReaction ;

    @PostMapping("/addReaction")
    public Reaction caddReaction(@RequestParam Integer user, @RequestParam Long message, @RequestBody String reaction) {
        return iGestionReaction.addReaction(user,message,reaction);
    }

    @PutMapping("/deleteReaction")
    public boolean cdeleteReaction(@RequestParam Long id) {
        return iGestionReaction.deleteReaction(id);
    }

}
