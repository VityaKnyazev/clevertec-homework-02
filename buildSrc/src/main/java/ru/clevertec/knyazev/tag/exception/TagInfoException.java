package ru.clevertec.knyazev.tag.exception;

public class TagInfoException extends RuntimeException {

    public TagInfoException() {
        super();
    }

    public TagInfoException(String message) {
        super(message);
    }

    public TagInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TagInfoException(Throwable cause) {
        super(cause);
    }

}
