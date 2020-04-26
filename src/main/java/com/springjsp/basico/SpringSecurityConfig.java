package com.springjsp.basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springjsp.basico.auth.handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		PasswordEncoder encoder = passwordEncoder();
//		UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication()
			.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
			.withUser(users.username("juan").password("12345").roles("USER"));
	}
	
	
	/*
	 * Método que se debe sobreescribir para personalizar la configuración de seguridad
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/", "/resources/bootstrap-4.4.1-dist/**", "/resources/css/**", "/resources/js/**", "/resources/images/**", "/autores/home").permitAll()
				.antMatchers("/autores/**").hasAnyRole("ADMIN")
				.antMatchers("/libro/detalle/**").hasAnyRole("USER")
				.antMatchers("/nuevoLibro/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
//				.successHandler(successHandler)
				.loginPage("/login")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/error_403");
		
	}

}
