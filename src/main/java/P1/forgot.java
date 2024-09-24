package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forgot")
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public forgot() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/instagram";
		String username="root";
		String password="test";
		String query="update details set pass=? where user=?";
		
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		String paas=request.getParameter("paas");
		
		try {
			PrintWriter w=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			PreparedStatement p=con.prepareStatement(query);
			p.setString(1, pass);
			p.setString(2, user);
			int x=p.executeUpdate();
			
			if(x>0) {
				RequestDispatcher r=request.getRequestDispatcher("pass.jsp");
				r.forward(request, response);
			}
				else {
					RequestDispatcher r=request.getRequestDispatcher("pass2.jsp");
					r.forward(request, response);	
				}
			con.close();					
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
