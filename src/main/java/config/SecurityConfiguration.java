package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
   @Autowired
   SecurityFilter securityFilter;
	
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	   return http
			  .csrf(csrf -> csrf.disable())
			  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			  .authorizeHttpRequests(authorize -> authorize
					  .requestMatchers(HttpMethod.GET,"/consultas", "/Paciente", "/Enderecos", "/TBEscala1", "/TBEscala2", "/TBEscala3").permitAll()
					  .requestMatchers(HttpMethod.GET,"/Usuario").hasRole("ADMIN")
					  .requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
					  .requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
					  .anyRequest().authenticated()
					 )
			  .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
			  .build();
   }
   
   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	   return authenticationConfiguration.getAuthenticationManager();
   }
   
   @Bean
   public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }
}