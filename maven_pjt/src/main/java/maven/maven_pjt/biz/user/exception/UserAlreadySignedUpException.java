package maven.maven_pjt.biz.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadySignedUpException extends RuntimeException {

    public UserAlreadySignedUpException(String message) {
        super(message);
    }

    public UserAlreadySignedUpException() {
        super("이미 가입된 아이디입니다.");
    }
}
