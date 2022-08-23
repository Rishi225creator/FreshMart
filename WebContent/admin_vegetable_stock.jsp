<%@include file="admin_header.jsp"%>
    <%@page import="java.util.*"%>
    <%@page import="project.com.bo.Product"%>
    <div id="admin-side-fruit">
        <div>
            <h2 align="center" style="color:rgb(26, 187, 158);font-size:30px;font-weight:bold">VEGETABLES LIVE DESCRIPTION</h2>
        </div>
        <div>
            <table border="2px">
                <tr>
                	<th>Id</th>
                    <th>Name</th>
                    <th>Quantity Left</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <%if(request.getAttribute("allProd")!=null){
                	List<Product> allProd=(List<Product>)(request.getAttribute("allProd"));
                	for(int pos=1;pos<=allProd.size();pos++){ %>
                <tr>
                	<%Product curr=allProd.get(pos-1); %>
                	<td><%=curr.getId() %>
                    <td><%=curr.getName().toUpperCase()%></td>
                    <td><%=curr.getQuantity()%>(Kgs)</td>
                    <td><%=curr.getPrice()%>/kgs</td>
                    <td><button><a href="updateproduct?id=<%=curr.getId()%>&type=<%=curr.getType()%>">Edit</a></button></td>
                    <td><button><a href="deleteproduct?id=<%=curr.getId()%>&type=<%=curr.getType()%>">Delete</a></button></td>
                </tr>
                	<%}
                }%>
            </table>
        </div>
    </div>
</body>
</html>