package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/UserDetails")
public class UserDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String password=req.getParameter("password");
		
		try
		{
			DriverManager.registerDriver(new Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal?user=root&password=root");
			PreparedStatement ps= con.prepareStatement("select * from user where Password=?");
			ps.setString(1, password);
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("record founded...");
				System.out.println("password found : "+password);
//				String name=rs.getString("name");
//				String password=rs.getString("password");
//				Long phone=rs.getLong("phone");
//				String adress=rs.getString("adress");
//				String gender=rs.getString("gender");
//				System.out.println(rs.getString("name")+" "+rs.getString("email")+" "+rs.getString("password")+" "+rs.getLong("phone")+" "+rs.getString("adress")+" "+rs.getString("gender"));
				
				//res.setContentType("html/text");
				pw.println("data found...");
				
				pw.println("<body>");
				pw.println("<center>");
				pw.println("<div style=\"margin-top:120px\">");
				pw.println("<table style=\"border: 2px solid black;border-collapse:collapse\">");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;color:red\">"+"Name"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+rs.getString("Name")+"</td>"+"</tr>");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Email"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+rs.getString("Email")+"</td>"+"</tr>");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Password"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+rs.getString("Password")+"</td>"+"</tr>");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Phone"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+rs.getString("Contact")+"</td>"+"</tr>");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Address"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+rs.getString("Address")+"</td>"+"</tr>");
				
				pw.println("<tr>"+"<th style=\"border: 2px solid black;\">"+"Gender"+"</th>");
				pw.println("<td style=\"border:2px solid black;\">"+rs.getString("Gender")+"</td>"+"</tr>");
				
				pw.println("</table>");
				pw.println("<br><br/>");
				pw.println("<a href=\"Dashboard.jsp\">Go To Dashboard</a>");
				pw.println("</div>");
				pw.println("</center>");
				pw.println("</body>");
				
			
			}
			else
			{
				System.out.println("record not found");
				pw.println("Record not founded with your provided credentials..");
				RequestDispatcher dispatcher = req.getRequestDispatcher("UserDetails.jsp");
                dispatcher.include(req, res);
			}
		}
		catch (Exception e) 
		{
			System.out.println("record not found in exception...");
			RequestDispatcher dispatcher = req.getRequestDispatcher("UserDetails.jsp");
            dispatcher.include(req, res);
		}
//		
	}

}
