package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.org.dao.LibrarianDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/com.org.servlets.LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCKTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Librarian Section</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		String email = request.getParameter("email");
		String password= request.getParameter("password");
		if(LibrarianDao.authenticate(email, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("email",email);
			
			request.getRequestDispatcher("").include(request, response);
			request.getRequestDispatcher("").include(request, response);
		}else {
			request.getRequestDispatcher("").include(request, response);
			out.println("<div class='container'>");
			out.println("<h3>Username and Password error</h3>");
			request.getRequestDispatcher("").include(request, response);
			out.println("</div");
			
			
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
