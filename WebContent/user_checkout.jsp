<%@include file="user_header.jsp" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="project.com.bo.User" %>
<%@page import="project.com.bo.Cart" %>
<%@page import="java.util.Random" %>
    <div id="my-history">
    	<%
    		User user=null;
    		if(session.getAttribute("user")!=null){
    			user=(User)(session.getAttribute("user"));
    		}
    		List<Cart> allCart=null;
    		if(request.getAttribute("allCart")!=null){
    			allCart=(ArrayList<Cart>)(request.getAttribute("allCart"));
    		}
    		String billNo="";
    		try{
				if(request.getSession().getAttribute("billNumber")==null){
					Random rand=new Random();
					while(billNo.length()!=10){
						billNo=billNo+rand.nextInt(9);
					}
					request.getSession().setAttribute("billNumber", billNo);
				}else{
					billNo=(String)request.getSession().getAttribute("billNumber");
				}
			}catch(Exception e){
				System.out.println("Bill Error Here");
			}
			long totalCost=0;
			long gst=0;
			String issue = null;
			if(request.getSession().getAttribute("Error") != null){
				issue = (String)request.getSession().getAttribute("Error");
			}
    	%>
        <div id="billing">
            <div id="name-plate"><h1>FreshMart</h1></div>
            <div id="bill-info">
                <table>
                    <tr>
                        <td>Bill Number</td>
                        <td><input type="text" value="<%=billNo %>" id="" readonly></td>
                    </tr>
                    <tr>
                        <td>Date</td>
                        <td><input type="text" value="<%=new java.util.Date()%>"></td>
                    </tr>
                    <tr>
                        <td>Customer name</td>
                        <td><input type="text" value="<%=user.getName()%>"></td>
                    </tr>
                    <tr>
                        <td>Mobile</td>
                        <td><input type="text" value="<%=user.getMobile() %>" id=""></td>
                    </tr>
                </table>
            </div>
            <%if(issue != null){%>
            	<h3 style="color:red"><%=issue %></h3>
            <%}%>
            <div id="items-info">
                <table border="2px">
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Price/Unit</th>
                        <th>Total</th>
                    </tr>
                    <%for(Cart curr:allCart){%>
                    	<tr>
                            <td><%=curr.getName() %></td>
                            <td><%=curr.getQuantity() %></td>
                            <td><%=curr.getPrice() %></td>
                            <td><%=(curr.getQuantity())*(curr.getPrice()) %></td>
                        </tr>
                        <%
                        	totalCost=totalCost+(curr.getQuantity())*(curr.getPrice());
                        %>
                    <%}
                    	gst=totalCost*9/100;
                    %>
                    <tr>

                        <td colspan="3" align="right">Subtotal</td>
                        <td><%=totalCost %></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">GST</td>
                        <td align="right">9%</td>
                        <td><%=gst %></td>
                    </tr>
                    <tr style="font-size:30px;font-weight: bold;">
                        <td colspan="3" align="right" style="font-size:25px">Total</td>
                        <td style="font-size:25px"><%=(totalCost+gst) %></td>
                    </tr>
                </table>
                <%if(allCart.size()>0){%>
                	<a href="placeNow"><input type="button" value="Place Order" id=""></a>
                <%}%>
                
            </div>
        </div>
    </div>
</body>

</html>