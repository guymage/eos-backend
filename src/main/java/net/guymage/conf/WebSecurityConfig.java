package net.guymage.conf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
		http.httpBasic();
		// Prise en compte des requêtes OPTIONS
		http.exceptionHandling().authenticationEntryPoint(new BasicAuthenticationEntryPoint() {
			@Override
			public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
				if(HttpMethod.OPTIONS.matches(request.getMethod())){
					response.setStatus(HttpServletResponse.SC_OK);
					response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeader(HttpHeaders.ORIGIN));
					response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS));
					response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, request.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_METHOD));
					response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
				}else{
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
				}
			}
		});
	}

}
