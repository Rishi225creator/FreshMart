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
    <link rel="shortcut icon" href="images/tab.ico">
    <title>FreshMart</title>
</head>
<body>
    <div class="front">
        <div class="front">
            <div class="sign-in">
             
                <div id="logo"><h1>FreshMart</h1></div>
                <fieldset>
                    <legend><h1>Log In</h1></legend>
                    <form action="loginuser" method="post">
                        <table>
                            <tr>
                                <td>User Id:</td>
                                <td><input type="text" name="userid"></td>
                            </tr>
                            <tr>
                                <td>Password:  </td>
                                <td><input type="password" name="password"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><button>Reset</button><button style="background-color:white;color:black;">Submit</button></td>
                            </tr>
                            <tr>
                                <td colspan="2"><button onclick="location.href='forgot_password.html'" style="width:200px;">Forget Password:</button></td>
                            </tr>
                        </table>
                    </form>
                </fieldset>
            </div>
    </div>
</body>
</html>