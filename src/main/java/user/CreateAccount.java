package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/Registration")
public class CreateAccount extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		
		System.out.println(name+" "+email+" "+password+" "+" "+phone+" "+address+" "+gender);
		
		try 
		{
			DriverManager.registerDriver(new Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal?createDatabaseIfNotExist=true","root","root");
			Statement s = con.createStatement();
			s.execute("create table if not exists user("
					+"Name varchar(45) not null ,"
					+"Email varchar(45) unique ,"
					+"Password varchar(45) primary key ,"
					+"Contact bigint not null ,"
					+"Address varchar(45) not null ,"
					+"Gender varchar(45) not null"
					+")");
			PreparedStatement ps= con.prepareStatement("insert into user (Name, Email, Password, Contact, Address, Gender) values(?,?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,password);
			ps.setString(4,phone);
			ps.setString(5,address);
			ps.setString(6,gender);
			
			if(ps.executeUpdate()>0)
			{
				//System.out.println("user created successfully...");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
				dispatcher.forward(req, res);
			}
		} 
		catch (Exception e) 
		{
			//System.out.println("Account creation is  unsuccessfully...");
			RequestDispatcher dispatcher=req.getRequestDispatcher("CreateAccount.jsp");
			dispatcher.include(req, res);
		}
	}

}
