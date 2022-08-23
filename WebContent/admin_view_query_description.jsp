<%@include file="admin_header.jsp" %>
    <%@page import="project.com.bo.Query" %>
    <div id="my-history">
        <div id="billing">
            <div id="name-plate" style="width:95%;margin:5px;"><h1>FreshMart Query Description</h1></div>
            <div id="show-desc">
                <table>
                	<%
                		String id=(String)(request.getParameter("id"));
                		String name=(String)(request.getParameter("name"));
                		String contact=(String)(request.getParameter("contact"));
                		String email=(String)(request.getParameter("email"));
                		String created=(String)(request.getParameter("created"));
                		String address=(String)(request.getParameter("address"));
                		String message=(String)(request.getParameter("message"));
                	%>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" value="<%=name%>" readonly></td>
                    </tr>
                    <tr>
                        <td>Mobile</td>
                        <td><input type="text" value="<%=contact%>" readonly></td>
                    </tr>
                    <tr>
                        <td>E-mail</td>
                        <td><input type="text" value="<%=email%>" readonly></td>
                    </tr>
                    <tr>
                        <td>Date</td>
                        <td><input type="text" value="<%=created%>" readonly></td>
                    </tr>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input type="text" value="<%=address%>" readonly></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
                            <textarea name="" id="" cols="30" rows="10" readonly><%=message %></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td><button ><a href="qdelete?id=<%=id%>">Delete</a></button></td>
                    </tr>
                </table>
            </div>
        </div>
        </div>
    </div>
</body>

</html>