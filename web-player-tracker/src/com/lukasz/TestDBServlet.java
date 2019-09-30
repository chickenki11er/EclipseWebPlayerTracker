package com.lukasz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.io.PrintWriter;
/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup conections variables
		String user= "postgres";
		String pass= "w3llgton";
		
		String jdbcUrl= "jdbc:postgresql://localhost/postgres";
		String driver= "org.postgresql.Driver";
		
		//get connection to the database
		try{
			PrintWriter out= response.getWriter();
			
			out.println("Connecting to database: "+ jdbcUrl);
			
			Class.forName(driver);
			
			Connection con= DriverManager.getConnection(jdbcUrl,user,pass);
			
			out.println("Succes");
			
			con.close();
		}catch(SQLException e) {
			System.err.format("SQL State: %s\n%s",e.getSQLState(),e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}
