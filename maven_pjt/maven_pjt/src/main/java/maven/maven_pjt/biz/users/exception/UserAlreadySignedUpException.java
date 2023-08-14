package maven.maven_pjt.biz.users.exception;

public class UserAlreadySignedUpException extends RuntimeException {

    public UserAlreadySignedUpException(String message) {
        super(message);
    }

    public UserAlreadySignedUpException() {
        super("이미 가입된 아이디입니다.");
    }
}
