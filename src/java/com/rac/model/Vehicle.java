/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rac.model;

/**
 *
 * @author personal
 */
public class Vehicle {
    
    private int Id;
    private String RegNo;
    private String ModelName;
    private String VehicleAvailability;
    private int CategoryId;

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
     * @return the RegNo
     */
    public String getRegNo() {
        return RegNo;
    }

    /**
     * @param RegNo the RegNo to set
     */
    public void setRegNo(String RegNo) {
        this.RegNo = RegNo;
    }

    /**
     * @return the ModelName
     */
    public String getModelName() {
        return ModelName;
    }

    /**
     * @param ModelName the ModelName to set
     */
    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    /**
     * @return the VehicleAvailability
     */
    public String getVehicleAvailability() {
        return VehicleAvailability;
    }

    /**
     * @param VehicleAvailability the VehicleAvailability to set
     */
    public void setVehicleAvailability(String VehicleAvailability) {
        this.VehicleAvailability = VehicleAvailability;
    }

    /**
     * @return the CategoryId
     */
    public int getCategoryId() {
        return CategoryId;
    }

    /**
     * @param CategoryId the CategoryId to set
     */
    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }
    
    
}
