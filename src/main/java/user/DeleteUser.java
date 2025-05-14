package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/DeleteUser")
public class DeleteUser extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		System.out.println(name+" "+password);
		
		try
		{
			DriverManager.registerDriver(new Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal?user=root&password=root");
			PreparedStatement ps= con.prepareStatement("delete from user where Name=? and Password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			
			if(ps.executeUpdate()>0)
			{
				System.out.println("data inserted successfully...");
				res.setContentType("text/html");
				PrintWriter pw=res.getWriter();
				pw.println("delted record successfully...");
				pw.println("<body>");
				pw.println("<center>");
				pw.println("<div style=\"margin-top:120px\">");
				pw.println("<table style=\"border: 2px solid black;border-collapse:collapse\">");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;color:red\">"+"Name"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+name+"</td>"+"</tr>");
				
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Password"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+password+"</td>"+"</tr>");
				
				pw.println("</table>");
				pw.println("<br><br/>");
				pw.println("<a href=\"Login.jsp\">Create Account</a>");
				pw.println("</div>");
				pw.println("</center>");
				pw.println("</body>");
			}
			else
			{
				System.out.println("unsuccessfull please try again...");
				RequestDispatcher dispatcher = req.getRequestDispatcher("DeleteUser.jsp");
                dispatcher.include(req, res);
			}
		}
		catch (Exception e)
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("DeleteUser.jsp");
            dispatcher.include(req, res);
		}
		
	}

}
