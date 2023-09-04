package maven.maven_pjt.biz.user;

import maven.maven_pjt.biz.user.dto.UpdateUserDto;
import maven.maven_pjt.biz.user.dto.UserSignInDto;
import maven.maven_pjt.biz.user.dto.UserSignUpDto;
import maven.maven_pjt.biz.user.dto.UserInfoDto;
import maven.maven_pjt.biz.user.entity.User;
import maven.maven_pjt.biz.user.exception.UserAlreadySignedUpException;
import maven.maven_pjt.biz.user.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer userId) { return userMapper.getUserById(userId);}
    public List<UserInfoDto> findAllUsersInfo() {
        return userMapper.findAllUsers();
    }

    public UserInfoDto getUserDetail(Integer userId) { return userMapper.getUserDetail(userId);}

    public UserInfoDto updateUser(UpdateUserDto updateUserDto) {
        return userMapper.updateUser(updateUserDto);
    }

    public Integer deleteUser(Integer userId) throws UserNotFoundException {
        User targetUser = getUserById(userId);

        if(targetUser == null) {
            throw new UserNotFoundException();
        } else {
            userMapper.deleteUser(userId);
            return userId;
        }
    }

    public void signUpUser(UserSignUpDto userSignUpDto) throws UserAlreadySignedUpException {
        if (userMapper.getUserByUserId(userSignUpDto.getUserId()) != null) {
            throw new UserAlreadySignedUpException();
        }
        userMapper.signUpUser(userSignUpDto);
    }

    public Integer getNewUserId() {
        return userMapper.getLastUserId()+1;
    }

    public UserInfoDto findUserByUserIdAndPassword(UserSignInDto userSignInDto) {
        return userMapper.findUserByUserIdAndPassword(userSignInDto);
    }
}
