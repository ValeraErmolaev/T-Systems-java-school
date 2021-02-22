package vermolae.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vermolae.model.Enum.Permission;
import vermolae.security.CustomAuthenticationFailureHandler;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous().and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/allTariffs").permitAll()
                .antMatchers("/registration*").permitAll()
                .antMatchers("/tariff*").permitAll()
                .antMatchers("/tariff/**").permitAll()
//                .antMatchers("/show.ajax*").permitAll()
                .antMatchers("/map").permitAll()
//                .antMatchers("/tariff*/*").permitAll()
                .antMatchers("/Users*").hasAuthority(Permission.USER_WRITE.getPermission())
                .antMatchers("/user**").hasAuthority(Permission.USER_READ.getPermission())
                .antMatchers("/administration/**").hasAuthority(Permission.USER_WRITE.getPermission())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .permitAll()
                .defaultSuccessUrl("/auth/success")
//                .failureUrl("/fail_login")
                .failureHandler(authenticationFailureHandler())
                .and()
                .exceptionHandling()
//                .accessDeniedPage("/auth/login")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
}