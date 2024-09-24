package P1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sign")
public class sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public sign() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/instagram";
		String username="root";
		String password="test";
		String mobile=request.getParameter("mobile");
		String name=request.getParameter("name");
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		
		
		
		
		try {
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement s=con.createStatement();
			int x=s.executeUpdate("insert into details values('"+mobile+"','"+name+"','"+user+"','"+pass+"')");
			
		   if(x>0) {
			   RequestDispatcher r=request.getRequestDispatcher("sign1.jsp");
				  r.forward(request, response);
		   }
		   else {
			   pw.println("Not able to signup");
		   }
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

