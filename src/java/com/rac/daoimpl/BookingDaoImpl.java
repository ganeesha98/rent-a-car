/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.dao.BookingDao;
import com.rac.model.Booking;
import com.rac.databaseConnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public class BookingDaoImpl implements BookingDao {

    private String SelectQuery = "select booking_id, booking_date, booking_vehicle_id, booking_employee_id, "
            + " booking_status, booking_detail, booking_targeted_location, booking_payment_type, "
            + " booking_payment_amount, booking_customer_id from booking";

    @Override
    public boolean AddBooking(Booking Booking) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into booking (booking_id, booking_date, "
                + "booking_vehicle_id, booking_employee_id, booking_status, booking_detail, "
                + "booking_targeted_location, booking_payment_type, booking_payment_amount, "
                + "booking_customer_id) values (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, Booking.getId());
        ps.setDate(2, Booking.getDate());
        ps.setString(3, Booking.getVehicleId());
        ps.setInt(4, Booking.getEmployeeId());
        ps.setInt(5, 1);
        ps.setString(6, Booking.getDetails());
        ps.setString(7, Booking.getTargetedLocation());
        ps.setString(8, Booking.getPaymentType());
        ps.setBigDecimal(9, Booking.getPaymentAmount());
        ps.setString(10, Booking.getCustomerId());
        ps.executeUpdate();
        return true;

    }

    @Override
    public boolean UpdateBooking(Booking Booking) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update booking set booking_date=?, "
                + "booking_vehicle_id=?, booking_employee_id=?, booking_status=?, booking_detail=?, "
                + "booking_targeted_location=?, booking_payment_type=?, booking_payment_amount=?, "
                + "booking_customer_id=? where booking_id=?");
        ps.setInt(1, Booking.getId());
        ps.setDate(2, Booking.getDate());
        ps.setString(3, Booking.getVehicleId());
        ps.setInt(4, Booking.getEmployeeId());
        ps.setInt(5, 1);
        ps.setString(6, Booking.getDetails());
        ps.setString(7, Booking.getTargetedLocation());
        ps.setString(8, Booking.getPaymentType());
        ps.setBigDecimal(9, Booking.getPaymentAmount());
        ps.setString(10, Booking.getCustomerId());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean DeleteBooking(int BookingId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from booking where booking_id=?");
        ps.setInt(1, BookingId);
        ps.executeUpdate();
        return true;
    }

    @Override
    public ResultSet GetBookingByOneAttribute(String Attribute, String Condition, String Value) throws SQLException {
        return new commonDaoImpl().getResultByAttribute(SelectQuery, Attribute, Condition, Value);
    }

    @Override
    public ResultSet GetBookingByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet GetAllBookings() throws SQLException {
        return new commonDaoImpl().getAllRecords(SelectQuery);
    }

    public boolean updateBookingAsPending(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update booking set booking_status=1 where booking_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean updateBookingAsCancelled(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update booking set booking_status=0 where booking_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

}
