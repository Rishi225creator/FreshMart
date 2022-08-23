<%@include file="admin_header.jsp" %>
    <div class="front">
        <div class="sign-up">
            <div id="logo"><h1>FreshMart</h6></div>
            	<div id="user-created" align="center">
                <%
                	boolean productInserted=(boolean)(request.getAttribute("productInserted"));
                	String error=(String)(request.getAttribute("error"));
                	if(productInserted){
                %>
                	<h3 style="color:red;">Congratulations Successfully Product Inserted</h3>
                <%}else{ %>
                	<h3 style="color:red;">Product Cannot Added</h3>
                <%} %>
                	<button><a href="admin_home.jsp">Click To Go Back</a></button>
                </div>
        </div>
    </div>
</body>
</html>