package eu.domibus.configuration.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Abstract class for Domibus security configuration
 *
 * It extends {@link WebSecurityConfigurerAdapter} class and declares abstract methods
 * which need to be overridden by each implementation. Common code is exposed in non abstract methods.
 *
 * @author Catalin Enache
 * @since 4.1
 */
public abstract class AbstractWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        configureHttpSecurity(http);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        configureWebSecurity(web);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        configureAuthenticationManagerBuilder(auth);
    }


    /**
     * configure {@link HttpSecurity} - to be implemented
     *
     * @param http
     * @throws Exception
     */
    public abstract void configureHttpSecurity(HttpSecurity http) throws Exception;

    /**
     * to be implemented
     * @param auth
     */
    protected abstract void configureAuthenticationManagerBuilder(AuthenticationManagerBuilder auth) throws  Exception;


    protected void configureWebSecurity(WebSecurity web) {
        web
                .ignoring().antMatchers("/services/**")
                .and()
                .ignoring().antMatchers("/ext/**");
    }
}