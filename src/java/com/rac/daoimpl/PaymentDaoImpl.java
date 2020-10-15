/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.databaseConnection.DatabaseConnection;
import com.rac.model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author personal
 */
public class PaymentDaoImpl {

    private String SelectQuesry = "select payment_id, payment_ref_no, payment_amount, "
            + " payment_status, payment_remark from payments";

    public boolean AddPayment(Payment payment) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into payments "
                + "(payment_ref_no, payment_amount, payment_remark) values (?,?,?)");
        ps.setString(1, payment.getRefNo());
        ps.setBigDecimal(2, payment.getAmount());
        ps.setString(3, payment.getRemark());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public ResultSet GetAllPayments() throws SQLException {
        return new commonDaoImpl().getAllRecords(SelectQuesry);
    }

    public boolean DeletePayment(int Id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from payments where payment_id=?");
        ps.setInt(1, Id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean UpdatePaymentAsCleared(int PaymentId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update payments set payment_status=0 where payment_id=?");
        ps.setInt(1, PaymentId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean UpdatePaymentAsNotCleared(int PaymentId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update payments set payment_status=1 where payment_id=?");
        ps.setInt(1, PaymentId);
        ps.executeUpdate();
        ps.close();
        return true;
    }
}
