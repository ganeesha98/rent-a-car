<%@page import="com.rac.daoimpl.VehicleDaoImpl"%>
<%@page import="com.rac.daoimpl.EmployeeDaoImpl"%>
<%@page import="com.rac.daoimpl.CustomerDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Management</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <!-- Google Fonts -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
        <!-- Bootstrap core CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.18.0/css/mdb.min.css" rel="stylesheet">

        <!-- JQuery -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.18.0/js/mdb.min.js"></script>

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
        <div style="z-index:20">
            <%@include file="navigationBar.jsp" %>
        </div>

        <div style="position: absolute; left: 2%; top: 20%; width: 25%">
            <form action="save_vehicle" method="post">
                <div class="container">

                    <input type="text" placeholder="Vehicle Model" name="vehicle_model_name" required style=" position: relative; top: 10%; width: 98%;">
                    <br>

                    <input type="text" placeholder="Reg No" name="vehicle_reg_no" required style=" position: relative; top: 10%; width: 98%;">
                    <br>

                    <button type="submit" style=" position: relative; width: 98%;">Save</button> 
                    <br>

                </div>
                <div class="container" style=" position: relative; width: 100%; background-color:#f1f1f1">
                </div>
            </form>
        </div>

        <div style="position: absolute; left: 10%; top: 15%; width: 80%; height: 80%; background-color: white; z-index:-1; border-radius: 20px">
        </div>
        <div class="container" style="position: absolute; left: 30%; top: 18%; width: 68%; height: 100%; z-index:-1">
            <h4>Manage Vehicles</h4>
            <%
                ResultSet rset = new VehicleDaoImpl().GetAllVehicles();
            %>
            <table class="table">
                <thead>
                    <tr style="background-color: #000000; color: white">
                        <th>Vehicle Model</th>
                        <th>Reg No</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rset.next()) {
                    %>
                    <tr class="info table-bordered" style="background-color: white">
                        <td><%= rset.getString("vehicle_model_name")%></td>
                        <td><%= rset.getString("vehicle_reg_no")%></td>
                        <td>
                            <div>
                                <%
                                    if (rset.getString("vehicle_availability").equalsIgnoreCase("1")) {
                                %>
                                <form action="updateVehicleAsUnavailable">
                                    <input type="submit"  value="Set As Unavailable" name="btn_inactive_user" class="form-control btn-danger m-0 px-3">
                                    <input type="hidden" name="hid_id" value="<%= rset.getString("vehicle_id")%>">
                                </form>
                                <%
                                } else {
                                %>
                                <form action="updateVehicleAsAvailable">
                                    <input type="submit"  value="Set As Available" name="btn_active_user" class="form-control  btn-default m-0 px-3">
                                    <input type="hidden" name="hid_id" value="<%= rset.getString("vehicle_id")%>">
                                </form>
                                <%
                                    }
                                %>
                            </div>
                        </td>
                        <td>   
                            <form action="delete_vehicle">
                                <input type="submit" value="Delete" name="delete_vehicle" class="form-control  btn-warning m-0 px-3">
                                <input type="hidden" name="hid_id" value="<%= rset.getString("vehicle_id")%>">
                            </form>         
                        </td>
                    </tr>
                    <%                     }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
