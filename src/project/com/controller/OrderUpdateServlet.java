package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.bo.Order;
import project.com.bo.User;
import project.com.util.DatabaseConnection;

@WebServlet("/orderupdate")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long orderId=Long.parseLong(request.getParameter("orderid"));
		Connection con = null;
		PreparedStatement pstmt = null;
		Integer rs = null;
		String sql = null;
		try{
			con = DatabaseConnection.getConnection();
			sql = "update freshmart_order set status=1 where bill_number=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,orderId);
			rs = pstmt.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("pendingorder");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
