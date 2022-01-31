package practice.kotlin.koard.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class SecurityConfig {

    @Throws(Exception::class)
    protected fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/user/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/")
    }

}