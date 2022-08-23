package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.util.DatabaseConnection;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/createuser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateUserServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
    	rd.forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String dob=request.getParameter("dob");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobileNumber");
		SimpleDateFormat sdf=new SimpleDateFormat("DD-mm-yyyy");
		java.util.Date date=null;
		java.sql.Date sqlDate=null;
		String error=null;
		try{
			date=sdf.parse(dob);
		}catch(Exception e){
			error=error+e.getMessage();
		}
		Long currDate=date.getTime();
		sqlDate=new java.sql.Date(currDate);
		Connection con=null;
		PreparedStatement pstmt=null;
		RequestDispatcher rd=null;
		boolean userCreated=false;
		int rs;
		try{
			con=DatabaseConnection.getConnection();
			String sql="insert into freshmart_users values(freshmart_users_seq.nextval,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setDate(2,sqlDate);
			pstmt.setString(3,email);
			pstmt.setString(4,mobile);
			pstmt.setString(5,userid);
			pstmt.setString(6,password);
			pstmt.setString(7, "user");
			rs=pstmt.executeUpdate();
			if(rs==1){
				userCreated=true;
			}
		}catch(Exception e){
			error=error+e.getMessage();
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("signup_success.jsp");
		request.setAttribute("userCreated",userCreated );
		request.setAttribute("error",error );
		rd.forward(request, response);
	}

}
