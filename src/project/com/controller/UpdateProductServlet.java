package project.com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import project.com.bo.Product;
import project.com.util.DatabaseConnection;

@MultipartConfig
@WebServlet("/updateproduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Long id=Long.parseLong(request.getParameter("id"));
		String sql=null;
		Product product=null;
		try{
			con=DatabaseConnection.getConnection();
			sql="select * from freshmart_veg_fru where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				product=new Product();
				product.setId(rs.getLong(1));
				product.setName(rs.getString(2));
				product.setType(rs.getString(3));
				product.setQuantity(rs.getInt(4));
				product.setPrice(rs.getLong(5));
				product.setImage(rs.getString(6));
			}
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		RequestDispatcher rd=request.getRequestDispatcher("admin_update_product.jsp");
		request.setAttribute("product", product);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		String category=request.getParameter("category");
		String name=request.getParameter("name");
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		Long price=Long.parseLong(request.getParameter("price"));
		Part image=request.getPart("image");
		String imgName=image.getSubmittedFileName();
		String uploadPathName="C:/myprojectsetup/workspace1/freshmart/WebContent/css/images/vegeis/"+imgName;
		FileOutputStream fos=new FileOutputStream(uploadPathName);
		RequestDispatcher rd=null;
		InputStream is=image.getInputStream();
		try{
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error Get");
		}
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=null;
		int rs=0;
		try{
			con=DatabaseConnection.getConnection();
			sql="update freshmart_veg_fru set name=?, type=?, quantity=?, price=?, image=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, category);
			pstmt.setInt(3, quantity);
			pstmt.setLong(4, price);
			pstmt.setString(5, imgName);
			pstmt.setLong(6, id);
			rs=pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("Problem In SQL"+e.getMessage());
		}
		rd=request.getRequestDispatcher("product-inserted.jsp");
		boolean isInserted=false;
		if(rs==1){
			isInserted=true;
		}
		request.setAttribute("productInserted", isInserted);
		rd.forward(request, response);
	}
}
