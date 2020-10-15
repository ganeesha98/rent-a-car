<%-- 
    Document   : addClient
    Created on : Apr 27, 2020, 11:18:07 AM
    Author     : Chamalki Madushika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Client Account</title>
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
        <%@include file="menu_header.jsp" %>
        <form action="addClient" method="POST">
            <div style="position: absolute; left: 35%; top: 12%; width: 30%; height: 80%">
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 17%; width: 20%; height: 15px">
                <h4>CREATE EMPLOYEE ACCOUNT</h4>
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 25%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="employee_name" name="employee_name" placeholder="Employee Name" required>
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 41%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="nic" name="nic"placeholder="NIC">
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 49%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="category_id" name="category_id" placeholder="Category Id">
            </div>
             <div class="form-group" style="position: absolute; left: 40%; top: 49%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="address" name="address" placeholder="Address">
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 33%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="contact_no" name="contact_no" placeholder="Contact No" required>
            </div>
             <div class="form-group" style="position: absolute; left: 40%; top: 49%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="email" name="email" placeholder="Email">
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 49%; width: 20%; height: 15px">
                <input type="text" class="form-control" id="remark" name="remark" placeholder="Remark">
            </div>
            <div class="form-group" style="position: absolute; left: 40%; top: 60%; width: 20%; height: 15px">
                <input type="submit" class="btn btn-info" value="Create Account">
            </div>
        </form>
    </body>
</html>
