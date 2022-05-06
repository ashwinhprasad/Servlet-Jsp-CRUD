package com.ashwin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		
		
		try {
			String dburl = "jdbc:mysql://localhost:3306/studentsDB";
			String uname = "ashwinhprasad";
			String passw = Creds.passw;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl,uname,passw);
			Statement st = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE name=?;");
			pstmt.setString(1,name);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next() && rs.getString("password").equals(password)) {
				
				
				HttpSession session = req.getSession();
				session.setAttribute("user", name);
				
				
				res.sendRedirect("index.jsp");
			} else {
				res.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
}
