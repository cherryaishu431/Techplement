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

@WebServlet("/Login")
public class Login extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String email=req.getParameter("email");
		String password = req.getParameter("password");
		res.setContentType("text/html");
        PrintWriter out = res.getWriter();
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_portal","root","root");
			PreparedStatement ps= con.prepareStatement("SELECT Password FROM user WHERE Email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				//System.out.println("email found....");
				String CorrectPassword=rs.getString("Password");
				
				if(CorrectPassword.equals(password))
				{
					// Correct password ===> got to Dashboard page
					RequestDispatcher dispatcher = req.getRequestDispatcher("Dashboard.jsp");
                    dispatcher.forward(req, res);
                    //System.out.println("password and email are correct");
				}
				else
				{
						// if password is incorrect
					 	req.setAttribute("errorMessage", "Incorrect password");
	                    RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
	                    dispatcher.forward(req, res);
	                    //System.out.println("incorrect password");
				}
			}
			else
			{
				// if entered email is incorrect
                req.setAttribute("errorMessage", "Incorrect email");
                RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
                dispatcher.forward(req, res);
                //System.out.println("email not found...");
			}
			rs.close();
            ps.close();
            con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
            req.setAttribute("errorMessage", "Server error: " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
            dispatcher.forward(req, res);
		}
	}

}
