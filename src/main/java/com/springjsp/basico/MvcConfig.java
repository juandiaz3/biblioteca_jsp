package com.springjsp.basico;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	private final Logger log = LoggerFactory.getLogger(MvcConfig.class);
	
	/* --- Configuración de la carpeta de recursos --- */
	
	private static final String[] PATH_RESOURCE_LOCATIONS = {
			"/resources/",
			"file:/C:/Temp/uploads/"
	};
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		log.info("Resource locations: " + PATH_RESOURCE_LOCATIONS);
		
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations(PATH_RESOURCE_LOCATIONS);
	}
	
	/* --- Fin Configuración carpeta recursos --- */
	
	/* --- Configuración de Internacionalización --- */
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
	
	
	/* --- Fin Configuración de Internacionalización --- */
	
	
	/* --- Registrar un controlador de vistas --- */
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/error_403").setViewName("errors/error_403");
	}
	
	/* --- Fin Registro controlador de vistas --- */
	
	
	/* --- Formateado de fecha --- */

	// Resuelve el locale, dónde se va a guardar
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("es", "ES"));
		return localeResolver;
	}

	// Interceptor que se encarga de cambiar el lenguaje
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		return localeInterceptor;
	}

	// Registrar el interceptor
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	/* --- --- */
	
	
	/* --- Upload files --- */
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(100000);
		return multipartResolver;
	}
	
	/* --- Fin configuración Upload files --- */
	
	/* --- Configuración Spring Security --- */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
