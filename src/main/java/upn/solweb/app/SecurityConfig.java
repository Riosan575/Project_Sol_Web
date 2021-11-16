package upn.solweb.app;

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
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/home", "/index", "/","/css/**", "/js/**", "/img/**").permitAll()
		.antMatchers("/views/cliente/**").hasAnyRole("ADMIN", "USER")
		.antMatchers("/views/cliente/crear/**").hasRole("ADMIN")
		.antMatchers("/views/cliente/save/**").hasRole("ADMIN")
		.antMatchers("/views/cliente/edit/**").hasRole("ADMIN")
		.antMatchers("/views/cliente/delete/**").hasRole("ADMIN")
		.antMatchers("/views/cliente").hasAnyRole("USER")
		.and()
		.formLogin()
		.loginPage("/login")
		.and()
		.exceptionHandling().accessDeniedPage("/errores/403");
		
		
		
		
	}
	
	
}
