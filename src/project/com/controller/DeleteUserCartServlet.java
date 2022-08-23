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

import project.com.util.DatabaseConnection;

@WebServlet("/deletecart")
public class DeleteUserCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DeleteUserCartServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		Long quantity=Long.parseLong(request.getParameter("quantity"));
		Long productId=Long.parseLong(request.getParameter("proId"));
		int rs=0;
		Connection con=null;
		String modifySql=null;
		RequestDispatcher rd=null;
		PreparedStatement pstmt=null;
		String sql=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="delete from freshmart_buylist where id= ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeUpdate();
			modifySql="update freshmart_veg_fru set quantity=? where id=?";
			pstmt=con.prepareStatement(modifySql);
			pstmt.setLong(1,getQuantity(productId)+quantity);
			pstmt.setLong(2, productId);
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("orderlist");
		rd.forward(request, response);
	}
	protected Long getQuantity(Long id){
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="select quantity from freshmart_veg_fru where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		try {
			if(rs.next()){
				return rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
