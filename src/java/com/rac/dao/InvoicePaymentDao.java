/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.dao;

import com.rac.model.InvoicePayment;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public interface InvoicePaymentDao {

    boolean addInvoicePayment(InvoicePayment invoicePayment) throws SQLException;
}
