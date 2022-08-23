package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.com.bo.User;
import project.com.util.DatabaseConnection;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/loginuser")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("signin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		HttpSession session=null;
		String sql=null;
		User user=null;
		RequestDispatcher rd=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="select * from freshmart_users where user_id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
				user.setDob(rs.getDate(3));
				user.setEmail(rs.getString(4));
				user.setMobile(rs.getString(5));
				user.setUser_id(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setUser_type(rs.getString(8));
			}else{
				rd=request.getRequestDispatcher("loginfail.jsp");
				rd.forward(request,response);
			}
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		request.getSession().setAttribute("user", user);
		if(user.getUser_type().equals("admin")){
			response.sendRedirect("admin_home.jsp");
		}else{
			response.sendRedirect("UserServlet");
		}
	}

}
