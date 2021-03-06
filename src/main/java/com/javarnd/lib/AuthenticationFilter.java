package com.javarnd.lib;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/book.jsp" })
public class AuthenticationFilter implements Filter {

	public void destroy() {
		// no-op
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpSession session = request.getSession(false);
		if ((String) session.getAttribute("username") == null)
			response.sendRedirect("login.jsp");
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// no-op
	}

}
