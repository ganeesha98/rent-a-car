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
public class VehicleCategory {
    
    private int Id;
    private String CategoryName;
    private String CategoryDetail;
    private int Status;

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
     * @return the CategoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     * @param CategoryName the CategoryName to set
     */
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    /**
     * @return the CategoryDetail
     */
    public String getCategoryDetail() {
        return CategoryDetail;
    }

    /**
     * @param CategoryDetail the CategoryDetail to set
     */
    public void setCategoryDetail(String CategoryDetail) {
        this.CategoryDetail = CategoryDetail;
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
    
    
    
    
}
