<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="stylesheet" href="css/main.css">
    <link rel="shortcut icon" href="css/images/tab.ico">
    <title>FreshMart</title>
</head>
<body>
    <div class="afterlogin" style="height:50px;width:100%;">
        <header>
            <nav>
                <div class="brand" style="width:10%;float:left;">FreshMart</div>
                <div class="dropdown" style="float:right;margin-right:40px;width:20%">
                    <button class="dropbtn">My Account</button>
                    <div class="dropdown-content">
                        <a href="userprofile">My Profile</a>
                        <a href="addproduct">Add Product</a>
                        <a href="fetchproduct?type=fruit">View Fruit</a>
                        <a href="fetchproduct?type=vegetable">View Vegetable</a>
                        <a href="pendingorder">View Order</a>
                        <a href="change_password.html">Change Password</a>
                        <a href="logout">Log Out</a>
                    </div>
                </div>
                <div class="menu" style="width:30%;float:right;">
                    <a href="admin_home.jsp">Home</a>
                    <a href="fetchproductwithimage?type=vegetable">Vegetable</a>
                    <a href="fetchproductwithimage?type=fruit">Fruit</a>
                </div>
            </nav>
        </header>
    </div>