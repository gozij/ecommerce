package com.tts.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tts.ecommerce.services.UserService;

@Configuration
@EnableWebSercurity
public class SercurityConfiguration extends WebSercurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManageBuilder auth) throws Exception {
		auth.userDetailsService(userService)
		                                  .passwordEncoder(bCryptPasswordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		    .authorizeRequests()
		    .antMatchers("/cart").authenticated()
		    .antMatchers("/charge").authenticated()
		    .and().formLogin()
		    .loginPage("/signin").permitAll()
		    .loginProcessingUrl("/login").permitAll()
		    .and().logout()
		    .logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		    .logout SuccessUrl("/");
		
	@Override
	public void configure(WebSecurity web) throws Exception{
		
		    
		.ignoring()
		.antMatchers("/console/**");
	}
		
	}
	} 

}
