<%
	User user=null;
	if(session.getAttribute("user")!=null){
		user=(User)session.getAttribute("user");
	}
	if(user==null){
		response.sendRedirect("loginuser");
	}
	if(user.getUser_type().equals("user")){%>
		<%@include file="user_header.jsp" %>
	<%}else{ %>
		<%@include file="admin_header.jsp" %>
	<%} %>
<%@page import="project.com.bo.User" %>
    <div id="my-profile">
        <div id="form-profile">
            <div id="profile-name-picture">
                <div style="width:15%;height:95px;float:left;margin-left:30px;padding:5px;">
                    <img src="aadesh.png" alt="" height="100px" width="100px">
                </div>
                <div style="width:30%;height:100px;float:left;margin-top:30px;">
                    Hi,
                    <h4><%=user.getName() %></h4>
                </div>
            </div>
            <div id="profile-address">
                <div id="my-order-profile" style="background-color:rgb(9, 225, 233);color:white;width:100%;height:40px;text-align: center;font-size:25px;">
                    My Information
                </div>
                <div id="profile-edit">
                    <table>
                        <tr><td><h2>Personal Information</h2></td></tr>
                        <tr><td>Name: <%=user.getName() %></td></tr>
                        <tr><td><h2>E-mail:</h2></td></tr>
                        <tr><td><%=user.getEmail() %></td></tr>
                        <tr><td><h2>Mobile Number:</h2></td></tr>
                        <tr><td><%=user.getMobile() %></td></tr>
                    </table>
                    <input type="button" onclick="location.href='userupdate'" value="Edit">
                </div>
            </div>
        </div>
    </div>
</body>
</html>