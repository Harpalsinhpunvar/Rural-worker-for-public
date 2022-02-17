package com.ruralworker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ruralworker.service.IUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class RuralworkerWebSecurityConfig extends WebSecurityConfigurerAdapter {
	
		@Bean
	    public UserDetailsService userDetailsService() {
	        return new IUserDetailsServiceImpl();
	    }
	     
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	         
	        return authProvider;
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        	.csrf().disable()
	        	.authorizeRequests()
	            .antMatchers("/getruralworkerdetails/varified").hasAnyAuthority("USER", "WORKER", "ADMIN")
	            .antMatchers("/registerruralworker").hasAuthority("WORKER")
	            .antMatchers("/updateruralworkerdetails/{registernumber}").hasAuthority("WORKER")
	            .antMatchers("/deleteruralworkerdetails/{registerNumber}").hasAuthority("WORKER")
	            .antMatchers("/getruralworkerdetails").hasAuthority("ADMIN")
	            .antMatchers("/getruralworkerdetails/unvarified").hasAuthority("ADMIN")
	            .antMatchers("/updateruralworkerdetails/varified/{registernumber}").hasAuthority("ADMIN")
	            .antMatchers("/registration").hasAuthority("ADMIN")
	            .anyRequest().authenticated()
	            .and()
	            .httpBasic()
	            .and()
	            .logout().permitAll()
	            .and()
	            .exceptionHandling().accessDeniedPage("/403");
	    }
	    

}
