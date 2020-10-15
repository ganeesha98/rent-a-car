
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Customer</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <head>
        <style>
            .btn {
                border: 2px solid black;
                background-color: white;
                color: black;
                padding: 14px 28px;
                font-size: 16px;
                cursor: pointer;
            }

            /* Green */
            .success {
                border-color: #4CAF50;
                color: green;
            }

            .success:hover {
                background-color: #4CAF50;
                color: white;
            }

            /* Blue */
            .info {
                border-color: #2196F3;
                color: dodgerblue;
            }

            .info:hover {
                background: #2196F3;
                color: white;
            }

            /* Orange */
            .warning {
                border-color: #ff9800;
                color: orange;
            }

            .warning:hover {
                background: #ff9800;
                color: white;
            }

            /* Red */
            .danger {
                border-color: #f44336;
                color: red;
            }

            .danger:hover {
                background: #f44336;
                color: white;
            }

            /* Gray */
            .default {
                border-color: #e7e7e7;
                color: black;
            }

            .default:hover {
                background: #e7e7e7;
            }
        </style>
    </head>
    <body>
        <%@include file="menu_header.jsp" %>
        <div style="position: absolute; left: 30%; top: 10%; width: 40%; height: 100%;">
            <form action="customer_register_servlet" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
                <h2 class="w3-center">Create Profile</h2>

                <div class="w3-row w3-section" style="position: relative; left: 10%; width: 80%">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" name="txt_name" type="text" placeholder="Full Name">
                    </div>
                </div>

                <div class="w3-row w3-section" style="position: relative; left: 10%; width: 80%">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" name="txt_address" type="text" placeholder="Address">
                    </div>
                </div>

                <div class="w3-row w3-section" style="position: relative; left: 10%; width: 80%">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" name="txt_email" type="text" placeholder="Email">
                    </div>
                </div>
                <div class="w3-row w3-section" style="position: relative; left: 10%; width: 80%">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-phone"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" name="txt_phone" type="text" placeholder="Phone">
                    </div>
                </div>
                <div class="w3-row w3-section" style="position: relative; left: 10%; width: 80%">
                    <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
                    <div class="w3-rest">
                        <input class="w3-input w3-border" name="txt_detail" type="Password" placeholder="Password">
                    </div>
                </div>
                <button class="w3-button w3-block w3-section w3-blue w3-ripple w3-padding" style="position: relative; left: 10%; width: 80%">Send</button>
            </form>
        </div>
    </body>
</html> 
