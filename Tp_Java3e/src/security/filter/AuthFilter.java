package security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.managerBeans.MembreLogin;


public class AuthFilter implements Filter{
	
	private FilterConfig config;

	@Override
	public void destroy() {
		
		this.setConfig(null);
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(((HttpServletRequest)request).getSession().getAttribute(MembreLogin.KEY_AUTH) == null){
			((HttpServletResponse)response).sendRedirect("./index.jsf");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.setConfig(config);
		System.out.println("ini filter");
		
	}

	public FilterConfig getConfig() {
		return config;
	}

	public void setConfig(FilterConfig config) {
		this.config = config;
	}



}
