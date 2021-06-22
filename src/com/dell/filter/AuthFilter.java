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
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/auth")
public class AuthFilter implements Filter {


    public AuthFilter() { }

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("-- Filter is initialised ---");
	}
	
	public void destroy() {
		System.out.println("-- Filter is destory ---");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String userEmail = request.getParameter("useremail");
		String password = request.getParameter("password");		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		if(!userEmail.equals("") && !password.equals("")) {
			if(userEmail.equals("admin@gmail.com") && password.equals("admin@123")) {
				
				chain.doFilter(request, response);
				
			} else {
				out.println("<h1 style='color:red'>Login Failed * Invalid credntials </h1>");
			}			
		} else {
			out.println("<h1 style='color:red'>Login Failed  * Required filled are missing! </h1>");
		}	
		
	}

	

}
