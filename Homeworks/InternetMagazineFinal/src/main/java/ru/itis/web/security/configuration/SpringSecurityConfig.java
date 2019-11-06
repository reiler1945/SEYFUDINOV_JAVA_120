package ru.itis.web.security.configuration;

import freemarker.template.Template;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// конфигурация безопасности, отменяет стандартную конфигурацию Spring Security
@EnableWebSecurity
@ComponentScan("ru.itis.web")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // поле, в котором хранится наш UserDetailsService
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    // шифратор паролей
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    // описание самой конфигурации
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // authorizeRequests - все запросы, которые описаны ниже
        // должны пройти через механизм авторизации
        http.authorizeRequests()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/cart/**").authenticated()
                .antMatchers("/chat/**").authenticated()
                .antMatchers("/articles/add").authenticated()
                .antMatchers("/articles/add").hasAuthority("ADMIN")
                .antMatchers("/articles/**").authenticated()
                //.antMatchers(HttpMethod.POST, "/articles/add").hasAuthority("ADMIN")
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/pay/**").authenticated()
                .antMatchers("/email/confirm").permitAll()
                .antMatchers("/signUp/**").permitAll()
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .defaultSuccessUrl("/profile")
                .failureUrl("/signIn?error")
                .usernameParameter("login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/signIn").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenRepository(persistentTokenRepository());
        http
                .csrf()
                .csrfTokenRepository(csrfTokenRepository());
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }

    // конфигурируем менеджер аутентификаций
    @Autowired
    protected void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        // кладем сюда свой userDetailsService
        // кладем свой энкодер паролей
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
