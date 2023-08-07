package ojt.ojt_be.biz.users.controller;

import ojt.ojt_be.biz.users.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user-service/user")
public class UsersController {

    @GetMapping("/")
    ResponseEntity findAllUsers() {
        HttpStatus status = HttpStatus.OK;
        System.out.println("get request arrived");

        return new ResponseEntity(status);
    }

    @PostMapping("/")
    ResponseEntity registerNewUser(@RequestBody Users user) {

        HttpStatus status = HttpStatus.CREATED;
        System.out.println("register user request arrived");

        return new ResponseEntity(status);
    }

    @GetMapping("/{userId}")
    ResponseEntity userDetail(@PathVariable String userId) {

        HttpStatus status = HttpStatus.OK;

        System.out.println("userId " + userId + " detail request arrived");

        return new ResponseEntity(status);
    }

    @PutMapping("/{userId}")
    ResponseEntity updateUserInfo(@RequestBody Users user) {
        HttpStatus status = HttpStatus.OK;
        System.out.println("update user info request arrived");

        return new ResponseEntity(status);
    }

    @DeleteMapping("/{userId}")
    ResponseEntity deleteUser(@PathVariable String userId) {
        HttpStatus status = HttpStatus.NO_CONTENT;

        return new ResponseEntity(status);
    }
}
