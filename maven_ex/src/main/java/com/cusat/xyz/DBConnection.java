package com.cusat.xyz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    public DBConnection() {
    	super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/Html");
		PrintWriter out=response.getWriter();
		Connection con=null;
		try
		{
			  String userName=request.getParameter("username");
			  String pass=request.getParameter("password");
			  Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","prabhat");
			  Statement st=con.createStatement();
			  String qry="select * from student1 where name='"+userName+"' and  pass='"+pass+"'";
			  ResultSet rs=st.executeQuery(qry);
			  if(rs.next())
			  {
				  out.print(rs.getInt(1)+ " "+rs.getString(2));
			  }
			  else{
				  out.print("No user found");
			  }
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally 
		{
			  try {
				  con.close();
			  } catch (SQLException e)  {
				  e.printStackTrace();
			  }
		}
	}
}