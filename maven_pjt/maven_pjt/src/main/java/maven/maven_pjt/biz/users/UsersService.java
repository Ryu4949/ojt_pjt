package maven.maven_pjt.biz.users;

import maven.maven_pjt.biz.users.dto.UpdateUserDto;
import maven.maven_pjt.biz.users.dto.UserSignInDto;
import maven.maven_pjt.biz.users.dto.UserSignUpDto;
import maven.maven_pjt.biz.users.dto.UsersInfoDto;
import maven.maven_pjt.biz.users.entity.Users;
import maven.maven_pjt.biz.users.exception.UserAlreadySignedUpException;
import maven.maven_pjt.biz.users.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersMapper usersMapper;

    public Users getUserById(Integer userId) { return usersMapper.getUserById(userId);}
    public List<UsersInfoDto> findAllUsersInfo() {
        return usersMapper.findAllUsers();
    }

    public UsersInfoDto getUserDetail(Integer userId) { return usersMapper.getUserDetail(userId);}

    public UsersInfoDto updateUser(UpdateUserDto updateUserDto) {
        return usersMapper.updateUser(updateUserDto);
    }

    public Integer deleteUser(Integer userId) throws UserNotFoundException {
        Users targetUser = getUserById(userId);

        if(targetUser == null) {
            throw new UserNotFoundException();
        } else {
            usersMapper.deleteUser(userId);
            return userId;
        }
    }

    public void signUpUser(UserSignUpDto userSignUpDto) throws UserAlreadySignedUpException {
        if (usersMapper.getUserByUserId(userSignUpDto.getUserId()) != null) {
            throw new UserAlreadySignedUpException();
        }
        usersMapper.signUpUser(userSignUpDto);
    }

    public Integer getNewUserId() {
        return usersMapper.getLastUserId()+1;
    }

    public UsersInfoDto findUserByUserIdAndPassword(UserSignInDto userSignInDto) {
        return usersMapper.findUserByUserIdAndPassword(userSignInDto);
    }
}
