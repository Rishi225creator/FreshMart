<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.com.bo.Cart"%>
<%@page import="project.com.bo.User"%>
<%
	User user = null;
	String userType = null;
	if(request.getSession().getAttribute("user") != null){
		user = (User)request.getSession().getAttribute("user");
		userType = user.getUser_type();
	}
	if(userType.equalsIgnoreCase("user")){
%>
		<%@include file="user_header.jsp"%>
<%}else{%>
		<%@include file="admin_header.jsp"%>
<%} %>
    <div id="my-history">
        <div id="view-history">
        <%
        	List<Cart> allOrder = null;
        	if(request.getSession().getAttribute("HistoryList") != null){
        		allOrder = (ArrayList<Cart>)request.getSession().getAttribute("HistoryList");
        	}
        
        %>
            <div>
                <div id="history">
                    <h2>History</h2>
                </div>
                <fieldset>
                    <legend>Bill Number: <%=allOrder.get(0).getBillNumber() %>&nbsp;</legend>
                    <table>
                        <tr>
                            <th>S.No</th>
                            <th>Product Name</th>
                            <th>Cost</th>
                            <th>Quantity</th>
                            <th>Total</th>
                        </tr>
                        <%
                        Long totalCost = 0l;
                        for(int sno = 1; sno<=allOrder.size(); sno++){
                        	Cart cart = allOrder.get(sno-1);
                        %>
                        <tr>
                            <td><%=sno%>.</td>
                            <td><%=cart.getName().toUpperCase() %></td>
                            <td><%=cart.getPrice() %></td>
                            <td><%=cart.getQuantity() %></td>
                            <td><%=cart.getPrice()*cart.getQuantity() %></td>
                            <%
                            	totalCost = totalCost + cart.getPrice()*cart.getQuantity();
                            %>
                        </tr>
                        <%} %>
                        <tr>
                        	<td colspan="4"><h3 style="color:red">Total Amount Paid: </h3></td>
                        	<td><h3 style="color:green"><%=totalCost+totalCost*9/100 %>(inc/gst)</h3></td>
                        </tr>
                        <%if(userType.equalsIgnoreCase("admin")){ %>
                        <tr>
                        	<td colspan="5"><a href="orderupdate?orderid=<%=allOrder.get(0).getBillNumber()%>">Mark Completed</a></td>
                        </tr>
                        <%} %>
                     </table>
                  </fieldset>
                </div>
              </div>
			</div>
<%if(userType.equalsIgnoreCase("user")){ %>
	<%@include file="user_footer.jsp"%>
<%}%>