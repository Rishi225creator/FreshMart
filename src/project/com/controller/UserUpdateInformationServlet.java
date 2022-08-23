package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.User;
import project.com.util.DatabaseConnection;

@WebServlet("/userupdate")
public class UserUpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UserUpdateInformationServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		rd=request.getRequestDispatcher("user_edit_profile.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		String name=request.getParameter("name");
		System.out.println(name);
		String email=request.getParameter("email");
		RequestDispatcher rd=null;
		String contact=request.getParameter("contact");
		String sql=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		int rs=0;
		try{
			con=DatabaseConnection.getConnection();
			sql="update freshmart_users set name=?, email=?, mobile=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, contact);
			pstmt.setLong(4, user.getId());
			rs=pstmt.executeUpdate();
			if(rs==1){
				user.setName(name);
				user.setEmail(email);
				user.setMobile(contact);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("user_profile.jsp");
		rd.forward(request, response);
	}

}
