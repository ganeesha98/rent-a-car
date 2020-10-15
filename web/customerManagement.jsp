<%@page import="com.rac.daoimpl.CustomerDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Management</title>
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
    </head>
    <body>
        <div style="z-index:20">
            <%@include file="navigationBar.jsp" %>
        </div>
        <div style="position: fixed; left: 0px; top: 0px; width: 100%; height: 100%; z-index:-1">
            <!--<img src="images/background-blur-clean-clear-531880.jpg">-->
        </div>
        <div style="position: absolute; left: 10%; top: 15%; width: 80%; height: 80%; background-color: white; z-index:-1; border-radius: 20px">
        </div>

        <div class="container" style="position: absolute; left: 12%; top: 18%; width: 76%; height: 100%; z-index:-1">
            <h4>Manage Customers</h4>
            <%
                ResultSet rset = new CustomerDaoImpl().GetAllCustomers();
            %>
            <table class="table">
                <thead>
                    <tr style="background-color: #000000; color: white">
                        <th>Customer Name</th>
                        <th>Email</th>
                        <th>Contact Number</th>
                        <th>Address</th>
                        <th>Status</th>
                        <th>Action</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rset.next()) {
                    %>
                    <tr class="info table-bordered" style="background-color: white">
                        <td><%= rset.getString("customer_name")%>
                        </td>
                        <td><%= rset.getString("customer_email")%></td>
                        <td><%= rset.getString("customer_contact_no")%></td>
                        <td style="width: 170px;"><%= rset.getString("customer_address")%></td>
                        <td>
                            <div>
                                <%
                                    if (rset.getString("customer_status").equalsIgnoreCase("1")) {
                                %>
                                <form action="updateUserAsActive">
                                    <input type="submit"  style="width: 150px" value="Deactivate User" name="btn_inactive_user" class="form-control btn-danger m-0 px-3">
                                    <input type="hidden" name="hid_cust_id" value="<%= rset.getString("customer_id")%>">
                                </form>
                                <%
                                } else {
                                %>
                                <form action="updateUserAsInactive">
                                    <input type="submit"  style="width: 150px" value="Activate User" name="btn_active_user" class="form-control  btn-default m-0 px-3">
                                    <input type="hidden" name="hid_cust_id" value="<%= rset.getString("customer_id")%>">
                                </form>
                                <%
                                    }
                                %>
                            </div>
                        </td>
                        <td>   
                            <form action="delete_customer">
                                <input type="submit" value="Delete" name="btn_delete_customer" class="form-control  btn-warning m-0 px-3">
                                <input type="hidden" name="hid_cust_id" value="<%= rset.getString("customer_id")%>">
                            </form>         
                        </td>
                    </tr>
                    <%                    }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
