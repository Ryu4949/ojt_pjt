package maven.maven_pjt.config;

import lombok.RequiredArgsConstructor;
import maven.maven_pjt.biz.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final UserService userService;
    private final String myKey = "KEY";

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, RememberMeServices rememberMeServices) throws Exception {
//        http
//                .httpBasic((httpBasic) -> httpBasic.disable())
//                .csrf(Customizer.withDefaults())
//                .rememberMe((remember) -> remember
//                        .rememberMeServices(rememberMeServices))
//                .authorizeHttpRequests(
//                        (authorize) -> authorize.requestMatchers("/", "/home", "/signup").permitAll()
//                                .requestMatchers("/note").hasRole("USER")
//                                .requestMatchers("/admin").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.POST, "/notice").hasRole("ADMIN")
//                                .requestMatchers(HttpMethod.DELETE, "/notice").hasRole("ADMIN")
//                                .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/")
//                        .permitAll())
//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/"));
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, RememberMeServices rememberMeServices) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }


    @Bean
    RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
        TokenBasedRememberMeServices.RememberMeTokenAlgorithm encodingAlgorithm = TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256;
        TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices(myKey, userDetailsService, encodingAlgorithm);
        rememberMe.setMatchingAlgorithm(TokenBasedRememberMeServices.RememberMeTokenAlgorithm.SHA256);
        return rememberMe;
    }

//    @Bean
//    public void configure(WebSecurity web) {
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            Users user = userService.getUserById(userId);
//            if (user == null) {
//                throw new UsernameNotFoundException(username);
//            }
//            return user;
//        };
//    }
}