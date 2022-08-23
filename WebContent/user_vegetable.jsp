<%@include file="user_header.jsp" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="project.com.bo.Product" %>
<%@page import="project.com.bo.User" %>
    <div class="vegetablefield" style="width:100%;height:500px;float:left;background-image: url('https://www.takemetour.com/amazing-thailand-go-local/wp-content/uploads/2018/03/Top-tea-plantations-in-Thailand-The-origin-of-Thai-oolong-tea-on-Doi-Wawee-Chiang-Rai.jpg');background-repeat: no-repeat;background-size: cover;"> 
    </div>
    <div class="vege-section">
        <div id="vegetable-table">
        	<%
        		List<Product> allProd=(ArrayList<Product>)(request.getAttribute("allProd"));
        		User user=(User)(session.getAttribute("user"));
        		if(request.getAttribute("prodAdded")!=null){
        			boolean productAdded=(boolean)request.getAttribute("prodAdded");
        			if(productAdded){%>
        				<h2 align="center" style="color:green;font-weight:bold">Successfully <span style="color:green;font-weight:bold">Added To Cart</span></h2>
        			<%}else{
        				if(request.getAttribute("lessquantity")!=null){
        					String lessquantity=(String)request.getAttribute("lessquantity");%>
        					<h2 align="center" style="color:green;font-weight:bold"><%=lessquantity %></h2>
        				<%}else{%>
        					<h2 align="center" style="color:red;font-weight:bold">Successfully <span style="color:green;font-weight:bold">Product Not Added</span></h2>
        				<%}
        		}
        	}%>
            <table>
                <tr>
                	<%for(int pro=1;pro<=allProd.size();pro++){
                		Product product=allProd.get(pro-1);
                	%>
                    <td>
                    	<form action="addcart">
	                        <img src="css/images/vegeis/<%=product.getImage() %>" alt="No Image Found">
	                        <%=product.getName().toUpperCase() %> Rs(<%=product.getPrice() %>/kg)<br>
	                        <input type="hidden" name="id" value="<%=product.getId() %>">
	                        <input type="hidden" name="name" value="<%=product.getName() %>">
	                        <input type="hidden" name="price" value="<%=product.getPrice() %>">
	                        <input type="hidden" name="type" value="<%=product.getType() %>">
	                        <input type="hidden" name="totalquantity" value="<%=product.getQuantity() %>">
	                        Select Qty: <input type="number" name="quantity" min="1" max="600" required><br>
	                        <input type="submit" value="Add to Cart">
                        </form>
                    </td>
                    <%if(pro%5==0){%>
                    	</tr>
                    	<tr>
                    <%}
                    } %>
				</tr>
            </table>
        </div>
        
    </div>
   
</body>
</html>