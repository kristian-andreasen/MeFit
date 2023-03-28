package noroff.mefit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException(int id) {
        super("Exercise does not exist with ID: " + id);
    }
    public ExerciseNotFoundException(String message) {
        super(message);
    }
    public ExerciseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ExerciseNotFoundException(Throwable cause) {
        super(cause);
    }
    public ExerciseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
