package com.ashwin;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/del")
public class DelStud extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			String dburl = "jdbc:mysql://localhost:3306/studentsDB";
			String uname = "ashwinhprasad";
			String passw = Creds.passw;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl,uname,passw);
			
			PreparedStatement pstmt = con.prepareStatement("DELETE from stud_info WHERE id=?;");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			res.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
