<%@include file="user_header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="project.com.bo.Cart"%>
<%@page import="java.util.ArrayList"%>
    <div id="my-history">
        <div id="billing">
            <div id="name-plate" style="width:95%;margin:5px;"><h1>FreshMart</h1></div>
            <div id="items-info" style="margin-top:50px;width:90%;">
            <%
            	List<Cart> allCart=(ArrayList<Cart>)(request.getAttribute("allCart"));
            %>
            <%if(allCart.size()>0){ %>
                <table border="2px" style="margin-left:10px;">
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Price/Unit</th>
                        <th>Total</th>
                        <th>Edit</th>
                    </tr>
                    <%for(Cart cart:allCart){ %>
                    <tr>
                        <td><%=cart.getName().toUpperCase() %></td>
                        <td><%=cart.getQuantity() %></td>
                        <td><%=cart.getPrice() %></td>
                        <%Long total= cart.getQuantity()*cart.getPrice();%>
                        <td><%=total%></td>
                        <td><button><a href="deletecart?id=<%=cart.getId()%>&quantity=<%=cart.getQuantity()%>&proId=<%=cart.getItemId()%>">Remove</a></button></td>
                    </tr>
                    <%} %>
                </table>
                <%}else{ %>
                	<h2 style="color:blue">Oops Nothing In The Cart To Show<span style="color:purple"> Continue Shopping</span></h2>
                <%} %>
            </div>
        </div>
    </div>
</body>

</html>