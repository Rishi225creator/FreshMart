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
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		Connection con=null;
		PreparedStatement pstmt=null;
		RequestDispatcher rd=null;
		boolean isDeleted=false;
		String sql=null;
		int rs=0;
		try{
			con=DatabaseConnection.getConnection();
			sql="delete from freshmart_veg_fru where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				DatabaseConnection.closeConnection();
			}catch(Exception e){
				
			}
		}
		rd=request.getRequestDispatcher("admin_product_deleted.jsp");
		if(rs==1){
			isDeleted=true;
		}
		request.setAttribute("isDeleted", isDeleted);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
