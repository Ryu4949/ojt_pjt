package maven.maven_pjt.biz.user;

import maven.maven_pjt.biz.user.dto.*;
import maven.maven_pjt.biz.user.exception.UserAlreadySignedUpException;
import maven.maven_pjt.biz.user.exception.UserNotFoundException;
import maven.maven_pjt.jwt.TokenDto;
import maven.maven_pjt.jwt.TokenRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        HttpStatus status = HttpStatus.OK;
        List<UserInfoDto> result = userService.findAllUsersInfo();
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity getUserDetail(@PathVariable("user_id") Integer userId) {
        HttpStatus status = HttpStatus.OK;
        UserInfoDto result = userService.getUserDetail(userId);

        return new ResponseEntity(result, status);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity updateUser(@PathVariable("user_id") Integer userId, @RequestBody UpdateUserDto updateUserDto) {
        HttpStatus status = HttpStatus.OK;
        userService.updateUser(updateUserDto);
        UserInfoDto result = userService.getUserDetail(userId);

        return new ResponseEntity(result, status);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity deleteUser(@PathVariable("user_id") Integer userId) throws UserNotFoundException {
        try {
            HttpStatus status = HttpStatus.NO_CONTENT;
            Integer result = userService.deleteUser(userId);
            return new ResponseEntity(result, status);

        } catch (UserNotFoundException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(e.getMessage(), status);
        }

    }

    @PostMapping
    public ResponseEntity signUpUser(@RequestBody UserSignUpDto userSignUpDto) throws UserAlreadySignedUpException {

        UserSignUpDto newUser = userSignUpDto;
        Integer newUserId = userService.getNewUserId();
        newUser.setId(newUserId);

        try {
            userService.signUpUser(newUser);
            UserInfoDto result = userService.getUserDetail(newUserId);
            HttpStatus status = HttpStatus.CREATED;
            return new ResponseEntity(result, status);

        } catch (UserAlreadySignedUpException e) {
            String result = e.getMessage();
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(result, status);
        }


    }

    @PostMapping("/signin")
    public ResponseEntity<TokenDto> signInUser(@RequestBody UserSignInDto userSignInDto) {
        System.out.println("hello world");
        UserInfoDto user = userService.findUserByUserId(userSignInDto);
        if (user == null || !passwordEncoder.matches(userSignInDto.getPassword(), user.getPassword())) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            String result = "아이디 또는 비밀번호가 잘못되었습니다.";
            return new ResponseEntity(result, status);
        } else {
            UserRequestDto userRequestDto = UserRequestDto.builder()
                    .userId(userSignInDto.getUserId())
                    .password(userSignInDto.getPassword())
                    .build();

            System.out.println("ㅇㅇㅇㅇ");
            return ResponseEntity.ok(userService.login(userRequestDto));
        }
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(userService.reissue(tokenRequestDto));
    }

}
