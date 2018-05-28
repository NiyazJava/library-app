package com.javarnd.lib;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class LoginServlet extends HttpServlet {
	private UserDao userDao;

	public LoginServlet() {
		userDao = UserDao.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.invalidate();
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserCredential user = new UserCredential();
		user.setUsername(username);
		user.setPassword(password);
		if (userDao.validateUser(user)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
		}
	}

}
