package com.dell.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class VisitCount
 */
@WebFilter(filterName="auth2",urlPatterns="/auth/*")
public class VisitCount implements Filter {

	static int count;
	
	public VisitCount() { }

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("-- VisitCount Filter is initialised ---");
	}
	
	public void destroy() {
		System.out.println("-- VisitCount Filter is destory ---");
	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// total website visit count logic
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		++count;		
		out.println("<h1> Total visits : "+count+ " </h1");		
		chain.doFilter(request, response);
		out.close();
	}


}
