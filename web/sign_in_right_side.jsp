<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            form {border: 3px solid #f1f1f1;}

            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
            }

            button:hover {
                opacity: 0.8;
            }

            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }

            .imgcontainer {
                text-align: center;
                margin: 24px 0 12px 0;
            }

            img.avatar {
                width: 100px;
                border-radius: 50%;
            }

            .container {
                padding: 16px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
        </style>
    </head>
    <body>
        <div style="position: absolute; left: 2%; top: 10%; width: 25%">
            <form action="static_admin_login" method="post">
                <div class="imgcontainer">
                    <img src="slider-images/avatar.png" alt="Avatar" class="avatar">
                </div>
                <div class="container">
                    <label for="uname"><b>Username</b></label><br>
                    <input type="text" placeholder="Enter Username" name="uname" required style=" position: relative; width: 25%;">
                    <br>
                    <label for="psw"><b>Password</b></label><br>
                    <input type="password" placeholder="Enter Password" name="pw" required style=" position: relative; width: 25%;">
                    <br>
                    <button type="submit" style=" position: relative; width: 25%;">Login</button> <br>
                    <label>
                        <input type="checkbox" checked="checked" name="remember" style=" position: relative; width: 25%;"> Remember me
                    </label><br>
                </div>
                <div class="container" style=" position: relative; width: 100%; background-color:#f1f1f1">
                    <button type="button" class="cancelbtn">Cancel</button>
                    <span class="psw">Forgot <a href="#">password?</a></span>
                </div>
            </form>
        </div>
    </body>
</html>
