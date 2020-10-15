/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.Booking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author personal
 */
public interface BookingDao {

    public boolean AddBooking(Booking Booking) throws SQLException;

    public boolean UpdateBooking(Booking Booking) throws SQLException;

    public boolean DeleteBooking(int BookingId) throws SQLException;

    public ResultSet GetBookingByOneAttribute(String Attribute, String Condition, String Value) throws SQLException;

    public ResultSet GetBookingByMoreAttributes(ArrayList<String[]> AttributeValueList, String Operator) throws SQLException;

    public ResultSet GetAllBookings() throws SQLException;

}
