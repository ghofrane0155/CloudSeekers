package tn.esprit.pidev.services.reclamation;

import tn.esprit.pidev.entities.reclamation.Reclamtion;

import java.util.List;

public interface IGestionReclamation {
List<Reclamtion>retrieveAllReclamation();
Reclamtion addReclamation(Reclamtion reclamtion);
Reclamtion updateReclamtion(Reclamtion reclamtion);

Reclamtion RetrieveReclamation(long idrec);
void deleteReclamation(long idrec);
/*addReclamtionAndAssignToUser*/
Reclamtion addReclamtionAndAssignToUser(Reclamtion reclamtion,Long id);
Reclamtion getReclamationByUserandReponse(Long id,long idrep);
List<Reclamtion> findAllReclamationsWithUserAndResponse();

}
