package practice.kotlin.koard.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import practice.kotlin.koard.config.oauth.PrincipalOAuth2UserService

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class SecurityConfig: WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var principalOAuth2UserService: PrincipalOAuth2UserService

    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/user/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
            .and()
            .logout()
            .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .and()
            .oauth2Login()
            .loginPage("/user/login")
            .userInfoEndpoint()
            .userService(principalOAuth2UserService);
    }
}