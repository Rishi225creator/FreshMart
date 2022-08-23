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
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=null;
		List<Product> vegSet=null;
		List<Product> fruSet=null;
		RequestDispatcher rd=null;
		ResultSet rs=null;
		try{
			con=DatabaseConnection.getConnection();
			vegSet=new ArrayList<Product>();
			fruSet=new ArrayList<Product>();
			sql="select * from freshmart_veg_fru";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setId(rs.getLong(1));
				product.setName(rs.getString(2));
				product.setType(rs.getString(3));
				product.setQuantity(rs.getInt(4));
				product.setPrice(rs.getLong(5));
				product.setImage(rs.getString(6));
				if(product.getType().equals("fruit")){
					fruSet.add(product);
				}else{
					vegSet.add(product);
				}
			}
			System.out.println("Hello No Problem");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("login_success_home.jsp");
		request.setAttribute("vegSet", vegSet);
		request.setAttribute("fruSet", fruSet);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
