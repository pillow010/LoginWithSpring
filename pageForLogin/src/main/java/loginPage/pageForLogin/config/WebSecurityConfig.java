package loginPage.pageForLogin.config;

import javax.sql.DataSource;

import loginPage.pageForLogin.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for web security.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * Creates and configures a UserDetailsService bean.
     *
     * @return the UserDetailsService bean
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    /**
     * Creates and configures a BCryptPasswordEncoder bean.
     *
     * @return the BCryptPasswordEncoder bean
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Creates and configures a DaoAuthenticationProvider bean.
     *
     * @return the DaoAuthenticationProvider bean
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    /**
     * Configures the security filter chain.
     *
     * @param http the HttpSecurity object
     * @return the configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/users").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("http://127.0.0.1:8080", true)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .csrf().disable();

        return http.build();
    }
}
