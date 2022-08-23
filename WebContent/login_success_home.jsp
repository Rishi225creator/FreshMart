<%@include file="user_header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="project.com.bo.Product"%>
    <div id="slider" style="float:left">
        <figure>
            <img src="https://thumbs.dreamstime.com/b/organic-vegetables-fruits-variety-table-kitchen-80751988.jpg" >
            <img src="css/images/animation-image.jpg">
            <img src="https://as1.ftcdn.net/v2/jpg/03/92/00/34/1000_F_392003452_1NdrDcyquNktebv8lYjTwszHND8dkatb.jpg">
        </figure>
    </div>
    <div class="go-buy-fruit">
        <div id="fruit-temp">
        </div>
        <%
        	List<Product> fruSet=(ArrayList<Product>)(request.getAttribute("fruSet"));
        	List<Product> vegSet=(ArrayList<Product>)(request.getAttribute("vegSet"));
        %>
        <div id="fruit-sale">
            <table>
                <tr>
                	<%
                	int i=1;
                	for(Product curr:vegSet){
                	%>
                    <td><a href="fetchproductwithimage?type=Vegetable"><img src="css/images/vegeis/<%=curr.getImage()%>" alt="">
                        <%=curr.getName().toUpperCase() %> &#8377;<%=curr.getPrice()%>/Kg<br>
                        M.R.P. &nbsp;<strike><%=curr.getPrice()+20 %>/Kg</strike>
                    </a></td>
                    
                		<%if(i==5){
                			break;
                		}
                		i++;
                    }%>
                </tr>
            </table>
        </div>
    </div>
    <div id="explore-vegeis">
        <a href="fetchproductwithimage?type=Vegetable">Click To Explore More Vegetable</a>
    </div>
    <div class="go-buy-fruit" style="margin-top:10px;">
        <div id="fruit-sale">
            <table>
                <tr>
                    <tr>
                	<%
                	i=1;
                	for(Product curr:fruSet){
                	%>
                    <td><a href="fetchproductwithimage?type=Fruit"><img src="css/images/vegeis/<%=curr.getImage()%>" alt="">
                        <%=curr.getName().toUpperCase() %> &#8377;<%=curr.getPrice()%>/Kg<br>
                        M.R.P. &nbsp;<strike><%=curr.getPrice()+20 %>/Kg</strike>
                    </a>
                    </td>
                		<%if(i==5){
                			break;
                		}
                		i++;
                    }%>
                </tr>
                </tr>
            </table>
        </div>
        <div id="explore-vegeis">
            <a href="fetchproductwithimage?type=Fruit">Click To Explore More Fruits</a>
        </div>
    </div>
</body>
</html>