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
        <div class="sign-up">
            <div id="logo"><h1>FreshMart</h6></div>
            <fieldset>
                <legend><h1>Create Account</h1></legend>
                <form action="createuser" method="post">
                    <table>
                        <tr>
                            <td>Name:</td>
                            <td><input type="text" name="name" required></td>
                        </tr>
                        <tr>
                            <td>User Id:</td>
                            <td><input type="text" name="userid" required></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password" required></td>
                        </tr>
                        <tr>
                            <td>Date Of Birth:  </td>
                            <td><input type="text" name="dob" required></td>
                        </tr>
                        <tr>
                            <td>E-mail:</td>
                            <td><input type="email" name="email" required></td>
                        </tr>
                        <tr>
                            <td>Mobile No:</td>
                            <td><input type="text" name="mobileNumber" required></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Submit" style="margin-down:4px;"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button style="width:200px;"><a href="signin.jsp">Already Have Account</a></button></td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </div>
    </div>
</body>
</html>