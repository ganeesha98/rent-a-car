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
 * @author personal
 */
public class Booking {

    private int Id;
    private Date Date;
    private String VehicleNo;
    private int EmployeeId;
    private int Status;
    private String Details;
    private String TargetedLocation;
    private String PaymentType;
    private BigDecimal PaymentAmount;
    private String CustomerName;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Date
     */
    public Date getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.Date = Date;
    }

    /**
     * @return the VehicleId
     */
    public String getVehicleId() {
        return VehicleNo;
    }

    /**
     * @param VehicleId the VehicleId to set
     */
    public void setVehicleId(String VehicleId) {
        this.VehicleNo = VehicleId;
    }

    /**
     * @return the EmployeeId
     */
    public int getEmployeeId() {
        return EmployeeId;
    }

    /**
     * @param EmployeeId the EmployeeId to set
     */
    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
    }

    /**
     * @return the Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * @return the Details
     */
    public String getDetails() {
        return Details;
    }

    /**
     * @param Details the Details to set
     */
    public void setDetails(String Details) {
        this.Details = Details;
    }

    /**
     * @return the TargetedLocation
     */
    public String getTargetedLocation() {
        return TargetedLocation;
    }

    /**
     * @param TargetedLocation the TargetedLocation to set
     */
    public void setTargetedLocation(String TargetedLocation) {
        this.TargetedLocation = TargetedLocation;
    }

    /**
     * @return the PaymentType
     */
    public String getPaymentType() {
        return PaymentType;
    }

    /**
     * @param PaymentType the PaymentType to set
     */
    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    /**
     * @return the PaymentAmount
     */
    public BigDecimal getPaymentAmount() {
        return PaymentAmount;
    }

    /**
     * @param PaymentAmount the PaymentAmount to set
     */
    public void setPaymentAmount(BigDecimal PaymentAmount) {
        this.PaymentAmount = PaymentAmount;
    }

    /**
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerName;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerName = CustomerId;
    }

}
