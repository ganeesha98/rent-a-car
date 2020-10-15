<%@page import="com.rac.daoimpl.VehicleDaoImpl"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div style="position: absolute; width: 100%; height: 100%; top: 0px; background-color: #ccccff">
            <%--<%@include file="menu_car_list.jsp" %>--%>
            <%@include file="menu_header.jsp"%>
            <%@include file="sign_in_right_side.jsp" %>
            <%@include file="home_feedback.jsp" %>
            <div class="container" style="position: absolute; left: 28%; top: 5%; width: 70%;">
                <h2>Available Vehicles</h2>
                <div class="list-group">
                    <%                    ResultSet rset = new VehicleDaoImpl().GetAllVehicles();
                        int i = 0;
                    %>
                    <table class="table table-bordered table-striped mb-0">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col"><i class="fas fa-image mr-2 grey-text" aria-hidden="true"></i>Vehicle Model</th>
                                <th scope="col"><i class="fas fa-book mr-2 grey-text" aria-hidden="true"></i>Reg No</th>
                                <th scope="col"><i class="fas fa-book mr-2 grey-text" aria-hidden="true"></i>Order Now</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                while (rset.next()) {
                            %>
                            <tr>
                        <form action="save_booking">
                            <th scope="row"><%= ++i%></th>
                            <td><%=rset.getString("vehicle_model_name")%></td>
                            <td><%=rset.getString("vehicle_reg_no")%></td>
                            <td><input type="submit"  style="width: 150px" value="Book Now" name="book_vehicle" class="form-control  btn-info m-0 px-3">
                                <input type="hidden" name="hid_id" value="<%=rset.getString("vehicle_reg_no")%>"/>
                            </td>
                        </form>

                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>               
                </div>
            </div>
        </div>
    </body>
</html>
