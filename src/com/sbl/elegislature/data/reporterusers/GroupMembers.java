/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.data.reporterusers;

import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class GroupMembers {

    private int id;
    private int level;
    private Date createdOn;
    private Date modifiedOn;
    private int employeeId;
    private int supervisorId;
    private int groupLeaderId;
    private int groupId;
    private int groupTypeId;
    private String groupName;
    private String groupTypeName;
    private String firstName;
    private String lastName;
    private String name;
    private Integer created_By;
    private Integer modified_By;

    public int getGroupLeaderId() {
        return groupLeaderId;
    }

    public void setGroupLeaderId(int groupLeaderId) {
        this.groupLeaderId = groupLeaderId;
    }

    public Integer getCreated_By() {
        return created_By;
    }

    public void setCreated_By(Integer created_By) {
        this.created_By = created_By;
    }

    public Integer getModified_By() {
        return modified_By;
    }

    public void setModified_By(Integer modified_By) {
        this.modified_By = modified_By;
    }

    public Integer getSessionDateId() {
        return SessionDateId;
    }

    public void setSessionDateId(Integer SessionDateId) {
        this.SessionDateId = SessionDateId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    private Integer SessionDateId;
    private boolean status;

    public GroupMembers() {

    }

    public GroupMembers(int id, String name, int level, int groupId) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.groupId = groupId;
    }

    public GroupMembers(int id, String name, int level, int groupId, String groupTypeName, int employeeId) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.groupId = groupId;
        this.groupTypeName = groupTypeName;
        this.employeeId = employeeId;
    }

    public GroupMembers(int id, String name) {
        this.employeeId = id;
        this.name = name;

    }

    public void setName() {
        name = firstName + " " + lastName;
    }

    public void setNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupTypeId() {
        return groupTypeId;
    }

    public void setGroupTypeId(int groupTypeId) {
        this.groupTypeId = groupTypeId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupTypeName() {
        return groupTypeName;
    }

    public void setGroupTypeName(String groupTypeName) {
        this.groupTypeName = groupTypeName;
    }

    public void setId(int id) {
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

//    private final SimpleStringProperty id;
//     private final SimpleStringProperty name;
//        private final SimpleStringProperty groupid;
//        private final SimpleStringProperty role;
//        private final SimpleStringProperty groupname;
//        private final SimpleStringProperty groupeTypeName;
//        private final SimpleStringProperty groupTypeId;
//        
//
// 
//         public Employee(String id,String name, String groupid,String role,String groupeTypeid,String groupeTypeName,String groupname) {
//             this.id=new SimpleStringProperty(id);
//            this.name = new SimpleStringProperty(name);
//            this.groupid = new SimpleStringProperty(groupid);
//            this.role = new SimpleStringProperty(role);
//            this.groupTypeId=new SimpleStringProperty(groupeTypeid);
//            this.groupeTypeName=new SimpleStringProperty(groupeTypeName);
//            this.groupname=new SimpleStringProperty(groupname);
//        }
//         
// 
//        public String getName() {
//            return name.get();
//        }
// 
//        public void setName(String fName) {
//            name.set(fName);
//        }
// 
//        public String getGroupid() {
//            return groupid.get();
//        }
// 
//        public void setGroupid(String fName) {
//            groupid.set(fName);
//        }
//                public String getId() {
//            return id.get();
//        }
// 
//        public void setId(String fName) {
//            id.set(fName);
//        }
//                public String getGroupeTypeName() {
//            return groupeTypeName.get();
//        }
// 
//        public void setGroupeTypeName(String fName) {
//            groupeTypeName.set(fName);
//        }
////                public String getId() {
////            return id.get();
////        }
//// 
////        public void setId(String fName) {
////            id.set(fName);
////        }
//             @Override
    public String toString() {
        return name;
    }
}
