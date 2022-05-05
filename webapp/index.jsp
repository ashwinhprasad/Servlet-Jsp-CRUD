<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student DB</title>
</head>
<body>
	<h1>Welcome to Student Database Management System</h1>
	<form action="addStud" method="post">
		<input type="text" name="name" placeholder="Enter Name"  >
		<input type="number" name="age" placeholder="Enter Age"  >
		<input type="number" name="year" placeholder="Enter Year"  >
		<input type="email" name="email" placeholder="Enter Mail"  >
		<input type="submit" value="add" />
	</form>
	
	<h2>List of Students</h2>
	<%@ page import="com.ashwin.Creds,java.sql.*" %>
	<% 
		String dburl = "jdbc:mysql://localhost:3306/studentsDB";
		String uname = "ashwinhprasad";
		String passw = Creds.passw;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dburl,uname,passw);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM stud_info");
		//st.close();
		//con.close();
		
	%>
	<%
	while(rs.next()){
		out.println("Id: "+rs.getString("id")+" - "+rs.getString("name")+" - "+rs.getString("year")+" Year <a href='del?id="+rs.getString("id")+"'>Delete</a> <br>");
	}
	%>
</body>
</html>