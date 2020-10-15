<%@page import="com.rac.daoimpl.PaymentDaoImpl"%>
<%@page import="com.rac.daoimpl.EmployeeDaoImpl"%>
<%@page import="com.rac.daoimpl.CustomerDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Management</title>
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

        <div style="position: absolute; left: 10%; top: 15%; width: 80%; height: 80%; background-color: white; z-index:-1; border-radius: 20px">
        </div>
        <div class="container" style="position: absolute; left: 10%; top: 18%; width: 80%; height: 100%; z-index:-1">
            <h4>Manage Payments</h4>
            <%
                ResultSet rset = new PaymentDaoImpl().GetAllPayments();
            %>
            <table class="table">
                <thead>
                    <tr style="background-color: #000000; color: white">
                        <th>Payment Reference</th>
                        <th>payment_amount</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rset.next()) {
                    %>
                    <tr class="info table-bordered" style="background-color: white">
                        <td><%= rset.getString("payment_ref_no")%></td>
                        <td><%= rset.getString("payment_amount")%></td>
                        <td>
                            <div>
                                <%
                                    if (rset.getString("payment_status").equalsIgnoreCase("1")) {
                                %>
                                <form action="updateAsClearedPayment">
                                    <input type="submit"  value="Mark As Cleared" name="btn_inactive_user" class="form-control btn-danger m-0 px-3">
                                    <input type="hidden" name="hid_id" value="<%= rset.getString("payment_id")%>">
                                </form>
                                <%
                                } else {
                                %>
                                <form action="updateAsPendingPayment"> 
                                    <input type="submit" value="Mark As Pending Payment" name="btn_active_user" class="form-control  btn-default m-0 px-3">
                                    <input type="hidden" name="hid_id" value="<%= rset.getString("payment_id")%>">
                                </form>
                                <%
                                    }
                                %>
                            </div>
                        </td>
                        <td>   
                            <form action="delete_payment">
                                <input type="submit" value="Delete" name="delete_payment" class="form-control  btn-warning m-0 px-3">
                                <input type="hidden" name="hid_id" value="<%= rset.getString("payment_id")%>">
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
