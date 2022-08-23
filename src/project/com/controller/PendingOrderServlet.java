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

import project.com.bo.Order;
import project.com.bo.User;
import project.com.util.DatabaseConnection;

@WebServlet("/pendingorder")
public class PendingOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		User user = (User)request.getSession().getAttribute("user");
		List<Order> orderList = null;
		try{
			con = DatabaseConnection.getConnection();
			sql = "select * from freshmart_order";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			orderList = new ArrayList<Order>();
			while(rs.next()){
				Order order = new Order();
				order.setBill_number(rs.getLong(1));
				order.setUser_id(rs.getLong(2));
				order.setBill_date(rs.getDate(3));
				order.setStatus(rs.getInt(4));
				orderList.add(order);
			}
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		request.getSession().setAttribute("OrderList", orderList);
		RequestDispatcher rd = request.getRequestDispatcher("admin_view_pending_order.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
