
<%@page import="com.rac.daoimpl.VehicleDaoImpl"%>
<%@page import="com.rac.daoimpl.loginDetailDaoImpl"%>
<%@page import="com.rac.daoimpl.CustomerDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <div class="card text-white bg-primary mb-3" style="max-width: 20rem; position: absolute; left: 30%; top: 17%; width: 15%; height: 80px; z-index:-1;">
            <div style="position: absolute; left: 0%; align-content: center; padding-top: 6%; width: 100%; height: 80px;"  class="card-header">
                <div style="position: absolute; left: 40%; align-content: center; padding-top: 2%">Active Customer</br>Accounts</div>          
            </div>
            <div style="position: absolute; left: 20%; top: 35%; width: 4%; height: 80px;">
                <%=new CustomerDaoImpl().GetAllActiveCustomersCount()%>
            </div>
        </div>
        <div class="card text-white bg-success mb-3" style="max-width: 20rem; position: absolute; left: 50%; top: 17%; width: 15%; height: 80px; z-index:-1;">
            <div style="position: absolute; left: 0%; align-content: center; padding-top: 6%; width: 100%; height: 80px;"  class="card-header">
                <div style="position: absolute; left: 40%; align-content: center; padding-top: 2%">Log </br> Count</div>          
            </div>
            <div style="position: absolute; left: 20%; top: 35%; width: 4%; height: 80px;">
                <%=new loginDetailDaoImpl().GetAllLogsCount()%>
            </div>
        </div>
        <div class="card text-white bg-danger mb-3" style="max-width: 20rem; position: absolute; left: 70%; top: 17%; width: 15%; height: 80px; z-index:-1;">
            <div style="position: absolute; left: 0%; align-content: center; padding-top: 6%; width: 100%; height: 80px;"  class="card-header">
                <div style="position: absolute; left: 40%; align-content: center; padding-top: 2%">Available </br> Vehicles</div>          
            </div>
            <div style="position: absolute; left: 20%; top: 35%; width: 4%; height: 80px;">
                <%=new VehicleDaoImpl().GetAllAvailableVehiclesCount()%>

            </div>
        </div>

    </body>
</html>
