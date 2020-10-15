/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.daoimpl;

import com.rac.databaseConnection.DatabaseConnection;
import com.rac.dao.InvoicePaymentDao;
import com.rac.model.InvoicePayment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Amal
 */
public class InvoicePaymentDaoImpl implements InvoicePaymentDao {

    @Override
    public boolean addInvoicePayment(InvoicePayment invoicePayment) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into invoice_payment (invoice_payment_date, invoice_payment_total, "
                + " invoice_payment_discount_rate, invoice_payment_discount_value, invoice_payment_cash, invoice_payment_discounted_total, "
                + "invoice_payment_invoice_no) values (?,?,?,?,?,?,?)");
        ps.setDate(1, invoicePayment.getDate());
        ps.setBigDecimal(2, invoicePayment.getTotal());
        ps.setBigDecimal(3, invoicePayment.getDiscountrate());
        ps.setBigDecimal(4, invoicePayment.getValue());
        ps.setBigDecimal(5, invoicePayment.getCash());
        ps.setBigDecimal(6, invoicePayment.getDiscountedTotal());
        ps.setInt(7, invoicePayment.getInvoiceNo());
        ps.executeUpdate();
        ps.close();
        return true;
    }
}
