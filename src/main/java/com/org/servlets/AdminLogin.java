package com.org.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/com.org.servlets.AdminLogin")
public class AdminLogin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Admin Section</title>");
        out.println("<link rel='stylesheet' href='bootstrap.min.css'");
        out.println("</head>");
        out.println("<body>");
        
        String email = request.getParameter("email");
        String password=request.getParameter("password");
        
        String e1 = "khamankar.suprit@gmail.com";
        String p1 = "admin123";
        
        if(email.equals(e1)&&password.equals(p1)) {
        	HttpSession session = request.getSession();
        	session.setAttribute("admin", "true");
        	
        	request.getRequestDispatcher("navadmin.html").include(request, response);
        	request.getRequestDispatcher("admincarousel.html").include(request, response);
        }else {
        	request.getRequestDispatcher("navhome.html").include(request, response);
        	out.println("<div class='container'");
        	out.println("<h3>Username or Password Error</h3>");
        	request.getRequestDispatcher("adminloginform.html").include(request, response);
        	out.println("</body>");
        }
		  request.getRequestDispatcher("footer.html").include(request, response);
		  out.close();
	}

}
