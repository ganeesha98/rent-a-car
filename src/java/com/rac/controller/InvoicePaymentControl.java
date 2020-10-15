/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.controller;

import com.rac.daoimpl.InvoicePaymentDaoImpl;
import com.rac.model.InvoicePayment;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public class InvoicePaymentControl {

    public static boolean addInvoicePayment(String invTotal, String diasountRate, String discountedTotal, String cash, int invoiceNo) throws SQLException {
        InvoicePayment invoicePayment = new InvoicePayment();
        invoicePayment.setDate(commonController.getCurrentJavaSqlDate());
        invoicePayment.setTotal(commonController.getBigDecimalOrZeroFromString(invTotal));
        invoicePayment.setDiscountrate(commonController.getBigDecimalOrZeroFromString(diasountRate));
        invoicePayment.setDiscountedTotal(commonController.getBigDecimalOrZeroFromString(discountedTotal));
        invoicePayment.setValue(commonController.getBigDecimalOrZeroFromString(diasountRate));
        invoicePayment.setCash(commonController.getBigDecimalOrZeroFromString(cash));
        invoicePayment.setInvoiceNo(invoiceNo);
        return new InvoicePaymentDaoImpl().addInvoicePayment(invoicePayment);
    }
}
