/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data.groups;


/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class GroupType {


    private Integer id ;
    private String name;
    private Boolean isActive = true;
    public GroupType()
    {
        
    }

    public GroupType(int id,String name)
    {
        this.name=name;
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

  
    @Override
    public String toString() {
        return name;
    }

//private final SimpleStringProperty id;
//private final SimpleStringProperty name;
//
//public GroupType(String id,String name)
//{
//    this.id=new SimpleStringProperty(id);
//    this.name=new SimpleStringProperty(name);
//}
//
//    public String getId() {
//        return id.get();
//    }
//
//    public String getName() {
//        return name.get();
//    }
//
//    public void setId(String ids)
//    {
//       id.set(ids);
//    }
//    public void setName(String names)
//    {
//        name.set(names);
//    }
//    
}
