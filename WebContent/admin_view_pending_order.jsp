<%@include file="admin_header.jsp"%>
    <%@page import="java.util.*"%>
    <%@page import="project.com.bo.Order"%>
    <div id="admin-side-fruit">
        <div>
            <h2 align="center" style="color:rgb(26, 187, 158);font-size:30px;font-weight:bold">Pending Orders</h2>
        </div>
        <div>
            <table border="2px">
                <tr>
                	<th>Bill Number</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>See Description</th>
                </tr>
                <%if(request.getSession().getAttribute("OrderList")!=null){
                	List<Order> orderList=(List<Order>)(request.getSession().getAttribute("OrderList"));
                	for(int pos=1;pos<=orderList.size();pos++){ %>
                <tr>
                	<%Order curr=orderList.get(pos-1); %>
                	<td><%=curr.getBill_number() %>
                    <td><%=curr.getBill_date()%></td>
                    <%if(curr.getStatus()==1){ %>
                    	<td><button><span style="color:green">Delivered</span></button></td>
                    <%}else{ %>
                    	<td><button><span style="color:red">Pending</span></button></td>
                    <%} %>
                    <td><button><a href="orderdescription?billNumber=<%=curr.getBill_number()%>">More Details</a></button></td>
                </tr>
                	<%}
                }%>
            </table>
        </div>
    </div>
</body>
</html>