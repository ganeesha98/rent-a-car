<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            .topnav {
                overflow: hidden;
                background-color: #00cccc;
            }

            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            .topnav a.active {
                background-color: #0099ff;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="#news">Rent a Car</a>
            <a href="register_customer.jsp">Sign In</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
        </div>
        <div style="position: absolute; left: 85%; top: 15px">
            <%
                HttpSession ses = request.getSession();
                String uname = (String) ses.getAttribute("uname");
            %>
            Hi, <%=(uname == null ? "User" : uname)%>
            <%
            %>
        </div>
        <div style="position: absolute; left: 80%; top: 0px; color: #ffff00; font-size: 15">
            <img src="images/logged-user.png"/>
        </div>
    </body>
</html>
