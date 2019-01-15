/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sbl.elegislature.service;

import okhttp3.RequestBody;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public interface ServiceClient {

    public String doGetRequest(String route);

    public String doPostRequest(String route, String json);
    
    public boolean doPostLoginRequest(String username,String password);
    
    public boolean doPostLogOutRequest();
}
