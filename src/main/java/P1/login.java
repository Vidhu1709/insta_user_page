package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/instagram";
		String username="root";
		String password="test";
		String query="select user from details where user=? and pass=?";
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");

		
		try {
			PrintWriter w=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1, user);
			p.setString(2, pass);
		
			ResultSet rs=p.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher r=request.getRequestDispatcher("logimage.jsp");
				r.forward(request, response);
				
			}
			else {
				RequestDispatcher r=request.getRequestDispatcher("logimage2.jsp");
				r.forward(request, response);
			}
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
