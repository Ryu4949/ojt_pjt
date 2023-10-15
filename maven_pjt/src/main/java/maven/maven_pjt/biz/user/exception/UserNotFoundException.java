package maven.maven_pjt.biz.user.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("존재하지 않는 사용자입니다.");
    }
}
