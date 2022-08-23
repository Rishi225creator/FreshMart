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

import project.com.bo.Product;
import project.com.util.DatabaseConnection;

/**
 * Servlet implementation class FetchFruitDescriptionServlet
 */
@WebServlet("/fetchproductwithimage")
public class ProductShowImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ProductShowImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String sql=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		RequestDispatcher rd=null;
		ResultSet rs=null;
		List<Product> allProd=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="select * from freshmart_veg_fru where lower(type)=lower(?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, type);
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
		}catch(Exception e){
			System.out.println("oh my god");
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		if("fruit".equals(type)){
			System.out.println("Hurrah");
			request.setAttribute("allProd", allProd);
			rd=request.getRequestDispatcher("admin_fruit_view.jsp");
			rd.forward(request, response);
		}else if((type).equals("vegetable")){
			request.setAttribute("allProd", allProd);
			rd=request.getRequestDispatcher("admin_vegetable_show.jsp");
			rd.forward(request, response);
		}else if("Vegetable".equals(type)){
			request.setAttribute("allProd", allProd);
			rd=request.getRequestDispatcher("user_vegetable.jsp");
			rd.forward(request, response);
		}else if("Fruit".equals(type)){
			request.setAttribute("allProd", allProd);
			rd=request.getRequestDispatcher("user_fruit.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
