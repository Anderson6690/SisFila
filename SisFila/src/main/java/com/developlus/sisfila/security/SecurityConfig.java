package com.developlus.sisfila.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Autowired(required = true)
	//private AppUserDetailsService appUserDetailsService;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("super").password("123").roles("COMUM");
        //auth.userDetailsService(appUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.exceptionHandling()
        		.and().authorizeRequests()
        		.and().exceptionHandling()
        			.accessDeniedPage("/AcessoNegado.xhtml")
                .and().authorizeRequests()
                	.antMatchers("/javax.faces.resource/**").permitAll()
                .and().authorizeRequests()
                	//.antMatchers("/cadastro-usuarios.jsf", "/cadastro-empresas.jsf").hasRole("ADMINISTRADOR")
                	.anyRequest().authenticated()
                .and().logout()
                	.logoutSuccessUrl("/Login.xhtml").permitAll()
                .and().formLogin()
                	.loginPage("/Login.xhtml")
                	.loginProcessingUrl("/appLogin")
                	.usernameParameter("app_username")
                    .passwordParameter("app_password")
                    .defaultSuccessUrl("/Dashboard.xhtml")
                    .failureUrl("/Login.xhtml").permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
        	.exceptionHandling().and().authorizeRequests().and()
                .exceptionHandling().accessDeniedPage("/AcessoNegado.xhtml").and().authorizeRequests()
                .antMatchers("/javax.faces.resource/**").permitAll()
            .and()
            	.authorizeRequests()
                .antMatchers("/**").hasRole("COMUM")
                .anyRequest().authenticated()
            .and()
            	.logout()
            	.logoutSuccessUrl("/Dashboard.xhtml").permitAll();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    */
}
