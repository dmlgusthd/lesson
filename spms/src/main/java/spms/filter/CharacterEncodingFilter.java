package spms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	FilterConfig config;
	
	
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}
	
	
	public void doFilter(
			ServletRequest request, ServletResponse response,
			FilterChain nextFilter) throws IOException, ServletException {
		System.out.println("CharacterEncodingFilter ½ÇÇà");
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		nextFilter.doFilter(request, response);
	}

	
	public void destroy() {}
}