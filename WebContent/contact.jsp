<!DOCTYPE html>
<html lang="en">
<head>
	<%@page import="project.com.bo.User" %>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@100&family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/main.css">
    <link rel="shortcut icon" href="images/tab.ico">
    <title>FreshMart</title>
</head>
<body>
	<%
		String name="";
		String mobile="";
		String email="";
		if(session.getAttribute("user")!=null){
			User user=(User)(session.getAttribute("user"));
			name=user.getName();
			mobile=user.getMobile();
			email=user.getEmail();
		}
    	if(request.getAttribute("queryAdded")!=null){
    		boolean queryAdded=(boolean)(request.getAttribute("queryAdded"));
    		if(queryAdded){%>
    			<h2 style="color:green;font-weight:bold" align="center">Query Successfully Added</h2>
    		<%}else{%>
    			<h2 style="color:red;font-weight:bold" align="center">Query Not Added</h2>
    		<%}
    	}%>
    <div class="front" style="float:left;">
        <div id="logo"><h1>FreshMart</h6></div>
        <fieldset id="about-us-text">
            <legend>About Us</legend>
            <p style=" padding-right: 4%; text-align: justify;text-justify: inter-word; padding-left: 3%; margin-top: 7%; color:white;font-size:22px;">Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio quisquam maiores excepturi tempore similique et. Hic error deserunt enim molestiae. Error quo, odit voluptatum non quibusdam aspernatur sequi incidunt voluptas rerum quisquam qui voluptatem. Eius, culpa quis iusto labore ea error amet dolorem eligendi neque delectus exercitationem quas cupiditate beatae explicabo mollitia placeat sit, illo veniam, ex nemo aliquid harum suscipit ad nisi. Vero rerum neque pariatur reiciendis natus enim consectetur earum laboriosam doloremque laborum dolores totam quibusdam placeat debitis, voluptas dicta impedit veritatis dignissimos aperiam laudantium commodi. Incidunt, eos sequi? Obcaecati similique eum perferendis aliquid alias fuga minus dolorem?</p> 
        </fieldset>
    </div>
    <div class="contact">
        <center> 
            <fieldset>
                <legend><h1>Query Form</h1></legend>
                <form action="addquery" method="post">
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" value=<%=name %>></td>
                        </tr>
                        <tr>
                            <td>Contact Number:  </td>
                            <td><input type="text" name="contact" value=<%=mobile %>></td>
                        </tr>
                        <tr>
                            <td>E-mail: </td>
                            <td><input type="text" name="email" value=<%=email %>></td>
                        </tr>
                        <tr>
                            <td>Address: </td>
                            <td><input type="text" name="address"></td>
                        </tr>
                        <tr>
                            <td>Message:</td>
                            <td><textarea name="message" id="" cols="5" rows="7"></textarea></td>
                        </tr>
                        <tr>
                            <td><button>Reset</button></td>
                            <td><input type="submit" value="Submit Query"></td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </center>
    </div>
</body>
</html>