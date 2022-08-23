<%@include file="user_header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.com.bo.Order" %>
    <div id="my-history">
        <div id="view-history">
            <div>
            	<%
            		List<Order> orderList = null;
            		if(request.getSession().getAttribute("OrderList")!=null){
            			orderList = (ArrayList<Order>)request.getSession().getAttribute("OrderList");
            			System.out.println("OrderList "+orderList);
            		}
            		System.out.println(orderList);
            	%>
                <div id="history">
                    <h2>History</h2>
                </div>
                <%for(Order order:orderList){ %>
                <fieldset style="height:121px;">
                    <legend>Order:<%=order.getBill_number() %>&nbsp;| Date:<%=order.getBill_date() %></legend>
                	<table>
                		<tr>
                			<th>Status</th>
                			<th>See More</th>
                		</tr>
                		<tr>
                			<td>
                				<%if(order.getStatus()==0){ %>
			                    	<h3 style="color:red">In Process</h3>
			                    <%}else{ %>
			                    	<h3 style="color:green">Delivered</h3>
			                    <%} %>
                			</td>
                			<td>
                				<a href="orderdescription?billNumber=<%=order.getBill_number()%>"><button>See Description</button></a>
                			</td>
                		</tr>
                    </table>
                </fieldset>
                <%} %>
            </div>
        </div>
    </div>
<%@include file="user_footer.jsp"%>