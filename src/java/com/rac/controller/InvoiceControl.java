/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.controller;

import com.rac.daoimpl.InvoiceDaoImpl;
import com.rac.model.Invoice;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceControl {

    public static int addInvoice(String total, String itemQty, String discountRate, String cashPay, int id, int userId) throws SQLException {
        InvoiceDaoImpl invoiceDaoImpl = new InvoiceDaoImpl();
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setDate(commonController.getCurrentJavaSqlDate());
        invoice.setTime(commonController.getCurrentJavaSqlTime());
        invoice.setUserId(userId);
        invoice.setTotal(commonController.getBigDecimalOrZeroFromString(total));
        invoice.setQty(commonController.getIntOrZeroFromString(itemQty));
        invoice.setDiscountRate(commonController.getBigDecimalOrZeroFromString(discountRate));
        invoice.setCustomerId(0);
        invoice.setCashPay(commonController.getBigDecimalOrZeroFromString(cashPay));
        return invoiceDaoImpl.addInvoice(invoice);
    }

    public static ResultSet getInvoicesByDateRange(String fromdate, String toDate) throws SQLException {
        return new InvoiceDaoImpl().getInvoicesByDateRange(fromdate, toDate);
    }

    public static ResultSet getInvoiceResultSetByInvoiceNo(String invoiceNo) throws SQLException {
        return new InvoiceDaoImpl().getInvoiceByOneAttribute("invoice_id", commonConstants.Sql.EQUAL, invoiceNo);
    }

    public static BigDecimal getDiscountedInvoiceProfit(Date fromDate, Date toDate) throws SQLException {
        return new InvoiceDaoImpl().getDiscountedInvoiceProfit(fromDate, toDate);
    }

    public static Invoice getInvoiceModelByInvoiceNo(String invoiceNo) throws SQLException {
        ResultSet rset = getInvoiceResultSetByInvoiceNo(invoiceNo);
        Invoice invo = null;
        while (rset.next()) {
            invo = new Invoice();
            invo.setId(rset.getInt("invoice_id"));
            invo.setDate(rset.getDate("invoice_date"));
            invo.setTime(rset.getTime("invoice_time"));
            invo.setUserId(rset.getInt("invoice_user_id"));
            invo.setTotal(rset.getBigDecimal("invoice_total"));
            invo.setQty(rset.getInt("invoice_item_qty"));
            invo.setDiscountRate(rset.getBigDecimal("invoice_discount_rate"));
            invo.setCustomerId(rset.getInt("invoice_cust_id"));
            invo.setCashPay(rset.getBigDecimal("invoice_cash_pay"));
        }
        return invo;
    }

    public static BigDecimal getInvoiceDiscountByInvoiceNo(int invoiceNo) throws SQLException {
        return new InvoiceDaoImpl().getInvoiceDiscountByInvoiceNo(invoiceNo);
    }

}
