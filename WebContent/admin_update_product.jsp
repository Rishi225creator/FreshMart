<%@include file="admin_header.jsp" %>
    <main style="height:500px">
        <div id="add-product-title">
            <h2>Update Product</h2>
        </div>
        <%@page import="project.com.bo.Product" %>
        <div id="add-product-details">
        	<%
        		Product product=null;
        		if(request.getAttribute("product")!=null){
        			product=(Product)(request.getAttribute("product"));
        		}
        	%>
            <form action="updateproduct" method="post" enctype="multipart/form-data">
                <table>
                 	<tr>
                        <td>Id:</td>
                        <td>
                            <input type="text" name="id" value="<%=product.getId() %>" placeholder="tomato/cherry" readonly>
                        </td>
                    </tr>
                    <tr>
                        <td>Select Category:</td>
                        <td>
                            <select name="category" value="<%=product.getType()%>" selected>
                                <option value="vegetable">Vegetable</option>
                                <option value="fruit">Fruit</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" value="<%=product.getName() %>" name="name" placeholder="tomato/cherry"></td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td><input type="number" min="1" name="quantity" value="<%=product.getQuantity() %>" placeholder="In Kgs/Dozen"></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><input type="text" value="<%=product.getPrice() %>" name="price"></td>
                    </tr>
                    <tr>
                        <td>Select Image:</td>
                        <td><input type="file" name="image" value="<%=product.getImage() %>" selected="selected"></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Reset"></td>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </main>
</body>
</html>