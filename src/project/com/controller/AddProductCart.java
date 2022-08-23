package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import project.com.bo.User;
import project.com.util.DatabaseConnection;

import javax.servlet.http.HttpServletResponse;


@WebServlet("/addcart")
public class AddProductCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddProductCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con=null;
		RequestDispatcher rd=null;
		String sql=null;
		String updateSql=null;
		PreparedStatement pstmt=null;
		System.out.println(request.getSession());
		User user=(User)request.getSession().getAttribute("user");
		String productType=null;
		System.out.println(user);
		int rs=0;
		Long productId=null;
		try{
			System.out.println(user.getName());
			productId=Long.parseLong(request.getParameter("id"));
			String productName=request.getParameter("name");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			Long totalQuantity=Long.parseLong(request.getParameter("totalquantity"));
			Long price=Long.parseLong(request.getParameter("price"));
			productType=(String)(request.getParameter("type"));
			if(totalQuantity>=quantity){
				con=DatabaseConnection.getConnection();
				sql="insert into freshmart_buylist values(freshmart_buylist_seq.nextval,null,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setLong(1, user.getId());
				pstmt.setLong(2, productId);
				pstmt.setString(3, productName);
				pstmt.setLong(4, quantity);
				pstmt.setLong(5, price);
				pstmt.setInt(6, 0);
				rs=pstmt.executeUpdate();
			}else{
				request.setAttribute("lessquantity", "!!!Only "+totalQuantity+" left");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		if(rs==1){
			System.out.println("Sucessfully Added Into Cart");
			request.setAttribute("prodAdded", true);
		}else{
			request.setAttribute("prodAdded", false);
		}
		if("vegetable".equals(productType)){
			rd=request.getRequestDispatcher("fetchproductwithimage?type=Vegetable");
		}else{
			rd=request.getRequestDispatcher("fetchproductwithimage?type=Fruit");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
