package com.javarnd.lib;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
	private UserDao userDao;

	public SignUpServlet() {
		userDao = UserDao.getInstance();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserCredential user = new UserCredential();
		user.setUsername(username);
		user.setPassword(password);
		userDao.addUser(user);
		resp.sendRedirect("login.jsp");
	}

}
