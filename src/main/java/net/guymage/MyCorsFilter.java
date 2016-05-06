package net.guymage;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filtre permettant d'ignorer les requêtes pre-flight du navigateur, car elles génèrent un erreur
 *
 * @author guymage
 *
 */
public class MyCorsFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse theResponse = (HttpServletResponse) response;
		HttpServletRequest theRequest = (HttpServletRequest) request;

		theResponse.setHeader("Access-Control-Allow-Origin", theRequest.getHeader("Origin"));

		if ("OPTIONS".equalsIgnoreCase(theRequest.getMethod())) {
			theResponse.setHeader("Access-Control-Allow-Credentials", "true");
			theResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, HEAD, OPTIONS, DELETE");
			theResponse.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization, X-HTTP-Method-Override");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
