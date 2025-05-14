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

@WebServlet("/UpdateUser")
public class UpdateUser extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		System.out.println(name+" "+password+" "+" "+address);
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal?user=root&password=root");
			PreparedStatement ps= con.prepareStatement("update user set Name=? ,Address=? where Password=?");
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setString(3,password);
			if(ps.executeUpdate()>0)
			{
				System.out.println("Update successful");
//				PrintWriter pw=res.getWriter();
				pw.println("data updated successfully...");
				pw.println("<body>");
				pw.println("<center>");
				pw.println("<div style=\"margin-top:120px\">");
				pw.println("<table style=\"border: 2px solid black;border-collapse:collapse\">");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;color:red\">"+"Name"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+name+"</td>"+"</tr>");		
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Password"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+password+"</td>"+"</tr>");
				
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Address"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+address+"</td>"+"</tr>");
				
				pw.println("</table>");
				pw.println("<br><br/>");
				pw.println("<a href=\"Dashboard.jsp\">Go To Dashboard</a>");
				pw.println("</div>");
				pw.println("</center>");
				pw.println("</body>");

			}
			else
			{
				pw.println("data not found updation failed");
				RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateUser.jsp");
                dispatcher.include(req, res);
				System.out.println("data not updated");
			}
		}
		catch(Exception e)
		{
			pw.println("data not found updation failed");
			RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateUser.jsp");
            dispatcher.include(req, res);
//			System.out.println("data not updated");
		}

	}

}
