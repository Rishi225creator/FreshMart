package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Query;
import project.com.util.DatabaseConnection;

/**
 * Servlet implementation class GetQueryServlet
 */
@WebServlet("/getquery")
public class GetQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public GetQueryServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		List<Query> allQuery=null;
		PreparedStatement pstmt=null;
		String sql=null;
		RequestDispatcher rd=null;
		ResultSet rs=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="select * from freshmart_query";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			allQuery=new ArrayList<Query>();
			while(rs.next()){
				Query query=new Query();
				query.setId(rs.getLong(1));
				query.setName(rs.getString(2));
				query.setContact(rs.getString(3));
				query.setEmail(rs.getString(4));
				query.setCreated(rs.getTimestamp(5));
				query.setAddress(rs.getString(6));
				query.setMessage(rs.getString(7));
				allQuery.add(query);
			}
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("admin_view_query.jsp");
		request.setAttribute("allQuery", allQuery);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
