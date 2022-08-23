<%@include file="admin_header.jsp" %>
    <%@page import="project.com.bo.Query" %>
    <%@page import="java.util.*" %>
    <div id="my-history">
        <div id="billing">
            <div id="name-plate" style="width:95%;margin:5px;"><h1>FreshMart Query List</h1></div>
            <div id="items-info" style="margin-top:50px;width:90%;">
            	<%
            		List<Query> allQuery=(ArrayList<Query>)(request.getAttribute("allQuery"));
            	%>
                <table border="2px" style="margin-left:10px;">
                    <tr>
                        <th>Name</th>
                        <th>Contact Number</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Date/Time</th>
                        <th>Edit</th>
                    </tr>
                    <%for(Query query:allQuery){%>
                    <tr>
                        <td><%=query.getName() %></td>
                        <td><%=query.getContact()%></td>
                        <td><%=query.getEmail()%></td>
                        <td><%=query.getCreated()%></td>
                        <td><%=query.getAddress()%></td>
                        <td><a href="admin_view_query_description.jsp?id=<%=query.getId()%>&name=<%=query.getName() %>&contact=<%=query.getContact()%>&email=<%=query.getEmail()%>&created=<%=query.getCreated()%>&address=<%=query.getAddress()%>&message=<%=query.getMessage()%>">See Description</a></td>
                    </tr>
                    <%}%>
                </table>
            </div>
        </div>
    </div>
</body>

</html>