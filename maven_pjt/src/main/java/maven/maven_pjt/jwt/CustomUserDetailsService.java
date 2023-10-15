package maven.maven_pjt.jwt;

import lombok.RequiredArgsConstructor;
import maven.maven_pjt.biz.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        return userMapper.getUserByUserId(userId)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(userId + "를 DB에서 찾을 수 없습니다."));
    }

    private UserDetails createUserDetails(maven.maven_pjt.biz.user.entity.User user) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getAuthority().toString());

        return new User(
                String.valueOf(user.getUsername()),
                user.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
