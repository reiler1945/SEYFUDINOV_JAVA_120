package ru.itis.service.exceptions;

public class UserExistsInFileRepositoryException extends RuntimeException {
    public UserExistsInFileRepositoryException(String message) {
        super(message);
    }
}
