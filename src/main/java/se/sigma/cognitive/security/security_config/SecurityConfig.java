package se.sigma.cognitive.security.security_config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import se.sigma.cognitive.security.repository.UserRepository;
import se.sigma.cognitive.security.service.UserService;

import java.util.Collection;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off



        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/"
                        , "/home"
                        , "/registration"
                        , "/forgot-password/"
                        , "/reset-password/"
                        , "/upload/"
                        , "/welcome"
                        , "/js/**"
                        , "/css/**"
                        , "/images/**"
                        , "/webjars/**"


                )
                .permitAll()

                .and()
                .authorizeRequests()
                .antMatchers("/user/admin/**").hasRole("ADMIN")
                .antMatchers("/user/super/**").hasRole("SUPER")
                .antMatchers("/user/partner/**").hasRole("PARTNER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/index" , true)
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .rememberMe()
                .and()
                .rememberMe()
                .key("uniqueAndSecret")
                .userDetailsService(userService);

    }


    //Beans
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(encoder());
        return auth;
    }



    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
