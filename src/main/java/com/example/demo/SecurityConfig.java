package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.Service.UsuariosSer;
	
@Configuration
public class SecurityConfig{
	@Autowired
    private UsuariosSer US;

	@Bean
    public PasswordEncoder encriptarPassword() {
        return NoOpPasswordEncoder.getInstance();
    }

	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
		auth.setUserDetailsService(US);
		auth.setPasswordEncoder(encriptarPassword());
		return auth;
	}
	
	@Bean(name="myPasswordEncoder")
	public PasswordEncoder getPasswordEncoder() {
        DelegatingPasswordEncoder delPasswordEncoder=  (DelegatingPasswordEncoder)PasswordEncoderFactories.createDelegatingPasswordEncoder();
        BCryptPasswordEncoder bcryptPasswordEncoder =new BCryptPasswordEncoder();
    delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
    return delPasswordEncoder;      
}
	// @Autowired
    // public void config(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(US).passwordEncoder(encriptarPassword());
    // }
	public void config(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{

		http.cors().and().csrf().disable();
		http.authorizeHttpRequests().anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/",true).permitAll()
		.and().logout().permitAll().invalidateHttpSession(true);
		return http.build();
	}
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)->web.ignoring().antMatchers("/CSS/**","/JS/**","/IMG/**");
    }

	
}
