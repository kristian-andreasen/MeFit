package noroff.mefit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class GoalNotFoundException extends RuntimeException {
    public GoalNotFoundException(int id) {
        super("Exercise does not exist with ID: " + id);
    }
    public GoalNotFoundException(String message) {
        super(message);
    }
    public GoalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public GoalNotFoundException(Throwable cause) {
        super(cause);
    }
    public GoalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
