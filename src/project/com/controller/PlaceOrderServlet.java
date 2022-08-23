package project.com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/placeNow")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String billNo="";
		try{
			if(request.getSession().getAttribute("billNumber")==null){
				Random rand=new Random();
				while(billNo.length()!=10){
					billNo=billNo+rand.nextInt(9);
				}
				request.getSession().setAttribute("billNumber", billNo);
			}else{
				billNo=(String)request.getSession().getAttribute("billNumber");
			}
		}catch(Exception e){
			System.out.println("Bill Error Here");
		}
		Long bill = Long.parseLong(billNo);
		Connection con = null;
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = (User)request.getSession().getAttribute("user");
		Long id = user.getId();
		List<Cart> allCart = null;
		List<Product> allProd = null;
		
		
		/*Get All Cart Product*/
		
		try{
			con = DatabaseConnection.getConnection();
			sql = "select * from freshmart_buylist where user_id=? and placed=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,id);
			pstmt.setInt(2,0);
			rs = pstmt.executeQuery();
			allCart=new ArrayList<Cart>();
			while(rs.next()){
				Cart cart=new Cart();
				cart.setBillNumber(rs.getLong(1));
				cart.setId(rs.getLong(2));
				cart.setUserId(rs.getLong(3));
				cart.setItemId(rs.getLong(4));
				cart.setName(rs.getString(5));
				cart.setQuantity(rs.getLong(6));
				cart.setPrice(rs.getLong(7));
				cart.setPlaced(rs.getInt(8));
				allCart.add(cart);
			}
			
		/*---------------------Fetch All The Product----------------*/
			
			sql="select * from freshmart_veg_fru";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			allProd=new ArrayList<Product>();
			while(rs.next()){
				Product product=new Product();
				product.setId(rs.getLong(1));
				product.setName(rs.getString(2));
				product.setType(rs.getString(3));
				product.setQuantity(rs.getInt(4));
				product.setPrice(rs.getLong(5));
				product.setImage(rs.getString(6));
				allProd.add(product);
			}
			
			
		/*-------Update all the stocks of fruit and vegetable-------*/
			
			sql = "update freshmart_veg_fru set quantity=? where id=?";
			pstmt = con.prepareStatement(sql);
			for(int i=0;i<allCart.size();i++){
				Cart cart=allCart.get(i);
				for(int j=0;j<allProd.size();j++){
					Product prod = allProd.get(j);
					if(cart.getItemId().equals(prod.getId())){
						if(prod.getQuantity()-cart.getQuantity()<0){
							RequestDispatcher rd = request.getRequestDispatcher("checkout");
							String issue = "Sorry!!! Only "+prod.getQuantity()+" Kgs Of "+prod.getName()+" Left Reset Your Choice Or Delete It From Cart";
							request.getSession().setAttribute("Error",issue);
							rd.forward(request, response);
						}
						pstmt.setLong(1, prod.getQuantity()-cart.getQuantity());
						pstmt.setLong(2, prod.getId());
						pstmt.executeUpdate();
					}
				}
			}
			
		/*----------------Now Place The Order Mark It Place And Insert BillNumber--------------------*/
			
			sql = "update freshmart_buylist set bill_number=?,placed=? where user_id=? and placed=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,bill);
			pstmt.setInt(2, 1);
			pstmt.setLong(3, user.getId());
			pstmt.setInt(4, 0);
			pstmt.executeQuery();
			
		/*---------------Now Insert Into Order Table------------------------------*/
			
			sql = "insert into freshmart_order values(?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, bill);
			pstmt.setLong(2, user.getId());
			pstmt.setInt(3, 0);
			pstmt.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		request.getSession().setAttribute("billNumber",null);
		RequestDispatcher rd = request.getRequestDispatcher("thankyou.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
