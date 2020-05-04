package com.springjsp.basico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springjsp.basico.auth.handler.LoginSuccessHandler;
import com.springjsp.basico.service.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JpaUserDetailsService jpaUserDetailsService;
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		// Recuperar los usuarios con JPA
		builder.userDetailsService(jpaUserDetailsService)
			.passwordEncoder(passwordEncoder);
		
		
		/* ------- Código en caso de no utilizar JDBC o JPA para la autenticación ------- 
//		UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication()
			.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
			.withUser(users.username("juan").password("12345").roles("USER"));
		*/
	}
	
	
	/*
	 * Método que se debe sobreescribir para personalizar la configuración de seguridad
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/", "/resources/bootstrap-4.4.1-dist/**", "/resources/css/**", "/resources/js/**", "/resources/images/**", "/autores/home").permitAll()
				.antMatchers("/libros/indexLibros").hasAnyRole("ADMIN")
				.antMatchers("/autores/**").hasAnyRole("ADMIN")
				.antMatchers("/libros/**").hasAnyRole("ADMIN")
				.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
				.antMatchers("/libros/ordenarLibros").hasAnyRole("ADMIN")
				.antMatchers("/libros/filtrarLibro").hasAnyRole("ADMIN")
				.antMatchers("/editoriales/**").hasAnyRole("ADMIN")
//				.antMatchers("/libro/detalle/**").hasAnyRole("USER")
//				.antMatchers("/nuevoLibro/**").hasAnyRole("ADMIN")
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
