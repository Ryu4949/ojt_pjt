package maven.maven_pjt.biz.users;

import lombok.Builder;
import maven.maven_pjt.biz.users.dto.UpdateUserDto;
import maven.maven_pjt.biz.users.dto.UserSignUpDto;
import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import maven.maven_pjt.biz.users.entity.Users;
import maven.maven_pjt.biz.users.exception.UserAlreadySignedUpException;
import maven.maven_pjt.biz.users.exception.UserNotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-service/users")
@CrossOrigin("*")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public ResponseEntity getAllUsers() {
        HttpStatus status = HttpStatus.OK;
        List<UsersInfoDto> result = usersService.findAllUsersInfo();
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity getUserDetail(@PathVariable("user_id") Integer userId) {
        HttpStatus status = HttpStatus.OK;
        UsersInfoDto result = usersService.getUserDetail(userId);

        return new ResponseEntity(result, status);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity updateUser(@PathVariable("user_id") Integer userId, @RequestBody UpdateUserDto updateUserDto) {
        HttpStatus status = HttpStatus.OK;
        usersService.updateUser(updateUserDto);
        UsersInfoDto result = usersService.getUserDetail(userId);

        return new ResponseEntity(result, status);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity deleteUser(@PathVariable("user_id") Integer userId) throws UserNotFoundException {
        try {
            HttpStatus status = HttpStatus.NO_CONTENT;
            Integer result = usersService.deleteUser(userId);
            return new ResponseEntity(result, status);

        } catch (UserNotFoundException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(e.getMessage(), status);
        }

    }

    @PostMapping
    public ResponseEntity signUpUser(@RequestBody UserSignUpDto userSignUpDto) throws UserAlreadySignedUpException {

        UserSignUpDto newUser = userSignUpDto;
        Integer newUserId = usersService.getNewUserId();
        newUser.setId(newUserId);

        try {
            usersService.signUpUser(newUser);
            UsersInfoDto result = usersService.getUserDetail(newUserId);
            HttpStatus status = HttpStatus.CREATED;
            return new ResponseEntity(result, status);

        } catch (UserAlreadySignedUpException e) {
            String result = e.getMessage();
            HttpStatus status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(result, status);
        }


    }

}
