/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sbl.elegislature.data.reporterusers;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class Reporters {
    
       private Integer id;
    private String firstName;
    private String lastName;

    public Reporters(String firstName, String lastName,String name, String designationName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.designationName = designationName;
        this.name=name;
    }
    private Integer departmentID;
    private Integer designationID;
    private String designationName;
    private String departmentName;
    private String name;
    
    public Reporters()
    {
        
    }

    public void setName()
    {
        name=firstName+" "+lastName;
    }
    public String getName()
    {
        return name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public Integer getDesignationID() {
        return designationID;
    }

    public void setDesignationID(Integer designationID) {
        this.designationID = designationID;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
        @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}