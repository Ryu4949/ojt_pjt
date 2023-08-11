package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        HttpStatus status = HttpStatus.OK;
        List<UsersInfoDto> result = usersService.findAllUsersInfo();
        return new ResponseEntity<>(result, status);
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity getUserDetail(@PathVariable("user_id") Integer userId) {
        HttpStatus status = HttpStatus.OK;
        UsersInfoDto result = usersService.getUserDetail(userId);

        return new ResponseEntity(result, status);
    }

}
