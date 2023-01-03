package com.back.itechdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpingBootSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(getEnecoder());
	}
	
	//Metodo para restringir el acceso a los diferentes tipos de usuarios
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()//csrf ayuda a que no se inyecte codigo malisioso a la app
		.antMatchers("/administrador/**").hasRole("ADMIN")//antMatchers permite decir a que contvistas va a tener acceso segun el rol q tenga
		.antMatchers("/productos/**").hasRole("ADMIN")
		.and().formLogin().loginPage("/usuario/login")//formLogin() establece la ruta en donde se va a cargar el formulario 
		.permitAll().defaultSuccessUrl("/usuario/acceder");//una ves q el usuario se logueo se va a ir a la direcccion de acceder ubicado en el usuarioControler
	}
	
	@Bean
	public BCryptPasswordEncoder getEnecoder() {
		return new BCryptPasswordEncoder();
	}
	

}
