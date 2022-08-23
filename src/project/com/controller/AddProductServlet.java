package project.com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import project.com.util.DatabaseConnection;

@MultipartConfig
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("add_product_detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category=request.getParameter("category");
		String name=request.getParameter("name");
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		Long price=Long.parseLong(request.getParameter("quantity"));
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
			sql="insert into freshmart_veg_fru values(freshmart_veg_fru_seq.nextval,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, category);
			pstmt.setInt(3, quantity);
			pstmt.setLong(4, price);
			pstmt.setString(5, imgName);
			rs=pstmt.executeUpdate();
		}catch(Exception e){
			
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
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
