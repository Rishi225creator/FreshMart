package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.util.DatabaseConnection;

/**
 * Servlet implementation class AddQueryServlet
 */
@WebServlet("/addquery")
public class AddQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddQueryServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("contact.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		RequestDispatcher rd=null;
		String address=request.getParameter("address");
		String message=request.getParameter("message");
		Connection con=null;
		String sql=null;
		PreparedStatement pstmt=null;
		java.util.Date now=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(now.getTime());
		int rs=0;
		try{
			con=DatabaseConnection.getConnection();
			sql="insert into freshmart_query values(freshmart_query_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2,contact);
			pstmt.setString(3, email);
			pstmt.setDate(4, sqlDate);
			pstmt.setString(5, address);
			pstmt.setString(6, message);
			rs=pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("SQL Error "+e.getMessage());
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("contact.jsp");
		if(rs==1){
			request.setAttribute("queryAdded", true);
		}else{
			request.setAttribute("queryAdded", false);
		}
		rd.forward(request, response);
	}

}
