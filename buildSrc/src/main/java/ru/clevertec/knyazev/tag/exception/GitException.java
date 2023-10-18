package ru.clevertec.knyazev.tag.exception;

public class GitException extends RuntimeException {

    public GitException() {
        super();
    }

    public GitException(String message) {
        super(message);
    }

    public GitException(String message, Throwable cause) {
        super(message, cause);
    }

    public GitException(Throwable cause) {
        super(cause);
    }

}
