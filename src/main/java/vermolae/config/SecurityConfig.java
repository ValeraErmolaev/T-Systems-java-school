package vermolae.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user1").password(passwordEncoder.encode("gg123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").access("hasRole('USER')")
                .antMatchers("/admin/** ** ").hasRole("ADMIN")
//                .antMatchers("/")
//                .permitAll()
//                .antMatchers("/**")
//                .hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/loginRegistration")
                .defaultSuccessUrl("/account")
                .failureUrl("/home?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home?logout=true")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf()
                .disable();


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**").anyRequest();
    }
}
