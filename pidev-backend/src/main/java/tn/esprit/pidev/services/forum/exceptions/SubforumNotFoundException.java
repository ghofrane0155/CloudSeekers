package tn.esprit.pidev.services.forum.exceptions;

public class SubforumNotFoundException extends RuntimeException{
    public SubforumNotFoundException(String message) {
        super(message);
    }
}
