<%@include file="admin_header.jsp" %>
    <%@page import="java.util.*" %>
    <%@page import="project.com.bo.Product" %>
    <div class="vegetablefield" style="width:100%;height:550px;float:left;background-image: url('css/images/admin_veg_background.jpg');background-repeat: no-repeat;background-size: cover;"> 
    </div>
    <div class="vege-section">
        <div id="vegetable-table">
		    <%
		    	List<Product> allProd=(ArrayList<Product>)(request.getAttribute("allProd"));
		    %>
            <table style="margin-top:20px;">
            <% int i=0; %>
                <tr>
            	<%for(Product product:allProd){
            		i++;
					%>
                    <td style="height:400px;width:15%;">
                        <img src="css/images/vegeis/<%=product.getImage() %>" alt="No Image Found">
                        <%=product.getName().toUpperCase() %> Rs(<%=product.getPrice() %>/kg)<br>
                        <button><a href="updateproduct?id=<%=product.getId() %>">Edit</a></button>
                    </td>
                    <%if(i%5==0){%>
					</tr>
					<tr>
					<%}
					} %>
					<td style="background-color:rgb(138, 255, 125);">
                        Add More Items<br>
                        Product Name<br>
                        <button onclick="location.href='addproduct'">Add Product</button>
                    </td>
         	</table>
         </div>
    </div>
</body>
</html>