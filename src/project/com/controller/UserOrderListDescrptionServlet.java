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

import project.com.bo.Cart;
import project.com.bo.User;
import project.com.util.DatabaseConnection;

@WebServlet("/orderdescription")
public class UserOrderListDescrptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long billNo = Long.parseLong(request.getParameter("billNumber"));
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		User user = (User)request.getSession().getAttribute("user");
		List<Cart> historyList = null;
		try{
			con = DatabaseConnection.getConnection();
			sql = "select * from freshmart_buylist where bill_number=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,billNo);
			rs = pstmt.executeQuery();
			historyList = new ArrayList<Cart>();
			while(rs.next()){
				Cart cart = new Cart();
				cart.setId(rs.getLong(1));
				cart.setBillNumber(rs.getLong(2));
				cart.setUserId(rs.getLong(3));
				cart.setItemId(rs.getLong(4));
				cart.setName(rs.getString(5));
				cart.setQuantity(rs.getLong(6));
				cart.setPrice(rs.getLong(7));
				cart.setPlaced(rs.getInt(8));
				historyList.add(cart);
			}
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		request.getSession().setAttribute("HistoryList", historyList);
		RequestDispatcher rd = request.getRequestDispatcher("user_history_description.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
