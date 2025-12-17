package com.jos.tktbooking;

import jakarta.servlet.ServletException;
import com.jos.dao.*;
import com.jos.model.*;
import java.util.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao = new UserDAO();

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGET called");
		List<UserModel> users = dao.getAllUsers();
		request.setAttribute("usersList", users);
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost called");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String pnum = request.getParameter("pnum");
		String email = request.getParameter("email");
		UserModel user = new UserModel(0, fname, lname, pnum, email);
		dao.addUser(user);
		List<UserModel> users = dao.getAllUsers();
		request.setAttribute("usersList", users);
		request.getRequestDispatcher("userinfo.jsp").forward(request, response);

	}

}
