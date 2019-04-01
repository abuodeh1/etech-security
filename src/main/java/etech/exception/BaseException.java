package etech.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Khalid Elshafie <abolkog@gmail.com>
 * @Created 18/09/2018 10:45 PM.
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
