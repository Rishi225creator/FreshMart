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
import project.com.bo.Product;
import project.com.bo.User;
import project.com.util.DatabaseConnection;

/**
 * Servlet implementation class UserOrderListServlet
 */
@WebServlet("/orderlist")
public class UserOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public UserOrderListServlet() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		RequestDispatcher rd=null;
		User user=(User)request.getSession().getAttribute("user");
		Long id=user.getId();
		System.out.println(id);
		ResultSet rs=null;
		List<Cart> allCart=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="select * from freshmart_buylist where user_id=? and placed=0";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			allCart=new ArrayList<Cart>();
			while(rs.next()){
				Cart cart=new Cart();
				cart.setId(rs.getLong(1));
				cart.setBillNumber(rs.getLong(2));
				cart.setUserId(rs.getLong(3));
				cart.setItemId(rs.getLong(4));
				cart.setName(rs.getString(5));
				cart.setQuantity(rs.getLong(6));
				cart.setPrice(rs.getLong(7));
				cart.setPlaced(rs.getInt(8));
				allCart.add(cart);
			}
		}catch(Exception e){
			System.out.println("oh my god");
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("user_view_order.jsp");
		request.setAttribute("allCart", allCart);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
