<%@include file="admin_header.jsp" %>
<body>
	<%
  		boolean isDeleted;
			isDeleted=(boolean)request.getAttribute("isDeleted");
			if(isDeleted){%>
				<h2 style="color:red;align:center;font-size:30;">Product Successfully Deleted</h2>
				<%if(request.getParameter("type").equals("fruit")){%>
					<a href="fetchproduct?type=fruit" style="color:red;align:center;font-size:30;">Go Back</a>
				<%}else{%>
					<a href="fetchproduct?type=vegetable" style="color:red;align:center;font-size:30;">Go Back</a>
				<%}%>
			<%}else{%>
				<h2 style="color:red;align:center;font-size:30;">Product Not Deleted</h2>
			<%}
	%>
	
</body>
</html>