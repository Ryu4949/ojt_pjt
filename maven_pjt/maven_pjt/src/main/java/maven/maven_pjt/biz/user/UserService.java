package maven.maven_pjt.biz.user;

import lombok.RequiredArgsConstructor;
import maven.maven_pjt.biz.user.dto.*;
import maven.maven_pjt.biz.user.entity.User;
import maven.maven_pjt.biz.user.exception.UserAlreadySignedUpException;
import maven.maven_pjt.biz.user.exception.UserNotFoundException;
import maven.maven_pjt.jwt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    JwtMapper jwtMapper;
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

    @Transactional
    public TokenDto reissue(TokenRequestDto tokenRequestDto) {

        if(!jwtTokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token이 유효하지 않습니다.");
        }

        Authentication authentication = jwtTokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        RefreshToken refreshToken = jwtMapper.findTokenByUserId(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃된 사용자입니다."));

        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(authentication);

        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        jwtMapper.saveRefreshToken(newRefreshToken);

        return tokenDto;
    }

    @Transactional
    public TokenDto login(UserRequestDto userRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = userRequestDto.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = jwtTokenProvider.generateTokenDto(authentication);

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        jwtMapper.saveRefreshToken(refreshToken);

        return tokenDto;
    }
}
