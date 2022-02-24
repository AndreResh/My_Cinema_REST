package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AwesomeControllerHandler {
    @ExceptionHandler(MyException.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchUserException(MyException e) {
        return new ResponseEntity<>(new AwesomeException(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AuthException.class)
    protected ResponseEntity<AwesomeException> handleAu(AuthException e) {
        return new ResponseEntity<>(new AwesomeException(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }


    private static class AwesomeException {
        private String error;

        public AwesomeException() {
        }

        public AwesomeException(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
