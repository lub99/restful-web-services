package com.courses.rest.webservices.restfulwebservices.error;

public class ErrorExplanationToUser {
    private final String message;
    private final String possibleCause;

    public ErrorExplanationToUser(String message, String possibleCause) {
        this.message = message;
        this.possibleCause = possibleCause;
    }

    public String getMessage() {
        return message;
    }

    public String getPossibleCause() {
        return possibleCause;
    }
}
