package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import maven.maven_pjt.biz.users.UsersMapper.*;

import java.util.List;

@RestController
@RequestMapping("/user-service")
public class UsersController {

    @GetMapping("/users")
    public ResponseEntity getAllUsers() {
        HttpStatus status = HttpStatus.OK;
        List<UsersInfoDto> result = findAllUsers

        return new ResponseEntity<>(status);
    }
}
