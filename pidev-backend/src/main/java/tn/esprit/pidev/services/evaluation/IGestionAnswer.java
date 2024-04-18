package tn.esprit.pidev.services.evaluation;


import tn.esprit.pidev.entities.evaluation.Answer;

import java.util.List;

public interface IGestionAnswer {
    List<Answer> retrieveAllReponses();
    Answer retrieveReponse (Long numReponse);
    Answer addReponse(Answer reponse);
    Answer updateReponse (Answer reponse);
    void removeReponse(Long numReponse);


    Answer addReponseAndAssignToQuestionAndUser(Answer reponse,Long numQuestion,Long numUser);
    List<Answer> getAllByUser (Long numUser);
    Answer getReponseByUserAndQuestion (Long numUser,Long numQuestion);

}
