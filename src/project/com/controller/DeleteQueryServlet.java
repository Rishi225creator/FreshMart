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

import project.com.util.DatabaseConnection;

@WebServlet("/qdelete")
public class DeleteQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DeleteQueryServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		Connection con=null;
		PreparedStatement pstmt=null;
		RequestDispatcher rd=null;
		boolean isDeleted=false;
		String sql=null;
		int rs=0;
		try{
			con=DatabaseConnection.getConnection();
			sql="delete from freshmart_query where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("getquery");
		if(rs==1){
			isDeleted=true;
		}
		request.setAttribute("isDeleted", isDeleted);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
