/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author Amal
 */
public class InvoicePayment {

    private int id;
    private Date date;
    private BigDecimal total;
    private BigDecimal discountrate;
    private BigDecimal value;
    private BigDecimal cash;
    private BigDecimal discountedTotal;
    private int invoiceNo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * @return the discountrate
     */
    public BigDecimal getDiscountrate() {
        return discountrate;
    }

    /**
     * @param discountrate the discountrate to set
     */
    public void setDiscountrate(BigDecimal discountrate) {
        this.discountrate = discountrate;
    }

    /**
     * @return the value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * @return the cash
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * @return the discountedTotal
     */
    public BigDecimal getDiscountedTotal() {
        return discountedTotal;
    }

    /**
     * @param discountedTotal the discountedTotal to set
     */
    public void setDiscountedTotal(BigDecimal discountedTotal) {
        this.discountedTotal = discountedTotal;
    }

    /**
     * @return the invoiceNo
     */
    public int getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * @param invoiceNo the invoiceNo to set
     */
    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

}
