<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@100&family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/main.css">
    <link rel="shortcut icon" href="css/images/tab.ico">
    <title>FreshMart</title>
</head>
<body>
    <div class="front">
        <div class="sign-up">
            <div id="logo"><h1>FreshMart</h6></div>
            	<div id="user-created" align="center">
                <%
                	boolean isUserCreated=(boolean)(request.getAttribute("userCreated"));
                	String error=(String)(request.getAttribute("error"));
                	if(isUserCreated){
                %>
                	<h3 style="color:red;">Congratulations Successfully Created The Profile</h3>
                	<button><a href="loginuser">Login Now</a></button>
                <%}else{ %>
                	<h3 style="color:red;">Cannot Create New User Use With Different E-mail Id</h3>
                	<button><a href="createuser">Create Now</a></button>
                <%} %>
                </div>
        </div>
    </div>
</body>
</html>