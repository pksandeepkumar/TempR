/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sbl.elegislature.login;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class UserDetails {
    
     @JsonProperty("username")
    private String username;
      @JsonProperty("password")
    private String password;

    
    public UserDetails()
    {
        username="admin";
        password="password";
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
