/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sbl.elegislature.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sbl.elegislature.service.ServiceClient;
import static com.sbl.elegislature.util.AppContext.APPLICATION_PROPERTIES;
import com.sbl.elegislature.util.AppUtils;
import com.sun.deploy.association.utility.AppUtility;
import java.io.File;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.framed.Header;
import okio.ByteString;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class ServiceClientImpl implements ServiceClient{
    private final String TOKEN_AUTH_USERNAME = "testjwtclientid";
    private final String TOKEN_AUTH_PASSWORD = "XY7kmzoNzl100";
    private final String TOKEN_NAME = "access_token";
    public static String bearerToken;
    
    public static String BASE_URL = " ";//eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoiYWRtaW4iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTM2MTkzOTkwLCJhdXRob3JpdGllcyI6WyJBRE1JTiJdLCJqdGkiOiI3NGRjYzI3Ny1iOWY3LTRlYmUtYTExMy1mMDI2YTk2MTI2OTgiLCJjbGllbnRfaWQiOiJ0ZXN0and0Y2xpZW50aWQifQ.6NReDkE5CbzYINeiQuL5NAjznZ9fep6MWuxAM8CADf0";
    private static OkHttpClient clientInstance;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public ServiceClientImpl() {
        clientInstance = new OkHttpClient();
    }


    @Override
    public String doGetRequest(String route) {
        
        String doGetRequest = "";
        try {
            Request.Builder builder = new Request.Builder();

            builder.url(BASE_URL + route);

            Request request = builder.addHeader("Authorization", "Bearer " + bearerToken).build();

            Response response = clientInstance.newCall(request).execute();
            System.out.println("\n\n\n response : " + response);
            doGetRequest = response.body().string();
            System.out.println("Response String : " + doGetRequest);

        } catch (IOException ex) {
            Logger.getLogger(ServiceClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doGetRequest;
    }

//    @Override
//    public String doPostRequest(String route, RequestBody body) {
//         String doPostRequest = "";
//        try {
//            Request.Builder builder = new Request.Builder();
//
//            builder.addHeader("RestAPI", "1");
//           // builder.addHeader("DeviceID", MAC_ADDRESS);
////            if (!"".equals(JSESSIONID)) {
////                builder.addHeader("SessionID", JSESSIONID);
////            }
//            builder.url(BASE_URL + route);
//
//            Request request = builder.post(body).build();
//
//            Response response = clientInstance.newCall(request).execute();
//            doPostRequest = response.body().string();
//        } catch (IOException ex) {
//            Logger.getLogger(ServiceClientImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return doPostRequest;
//    }
    
    @Override
    public String doPostRequest(String route, String json) {
          String doPostRequest = "";
        try {
            System.err.println("POST----------Param:" + json);
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder().addHeader("Authorization", "Bearer " + bearerToken)
                    .url(BASE_URL + route)
                    .post(body)
                    .build();
            Response response = clientInstance.newCall(request).execute();
            System.err.println("POST----------response:" + response);
            doPostRequest = response.body().string();
            System.err.println("POST----------doPostRequest:" + doPostRequest);
        } catch (IOException ex) {
            Logger.getLogger(ServiceClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doPostRequest;
    }

    
    
     @Override
    public boolean doPostLoginRequest(String username,String password) {
        bearerToken = "";
        String doPostRequest = "";
        HashMap response_token;
        try {

            RequestBody formBuilder = new FormBody.Builder().add("username", URLEncoder.encode(username, "UTF-8"))
                    .add("password", URLEncoder.encode(password, "UTF-8"))
                    .add("grant_type", "password")
                    .build();

            Request request = new Request.Builder().addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((TOKEN_AUTH_USERNAME 
                            + ":" + TOKEN_AUTH_PASSWORD).getBytes()))
                    .url("http://localhost:8080/Intranet/oauth/token").post(formBuilder).build();

            Response response = clientInstance.newCall(request).execute();
            
            

            doPostRequest = response.body().string();
            
            
            if (!doPostRequest.equals(null)) {
                
//                ObjectMapper mapper = new ObjectMapper();
//                mapper.writeValue(new File(AppUtils.LOGIN_FILE), doPostRequest);
                
                response_token = new ObjectMapper().readValue(doPostRequest, HashMap.class);

                if (response_token.containsKey("access_token")) {
                    bearerToken = (String) response_token.get("access_token");
                    AppUtils.writeStringAsFile(AppUtils.LOGIN_FILE, bearerToken);
                    System.out.println("Bearer Token :"+bearerToken);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ServiceClientImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bearerToken.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean doPostLogOutRequest() {
        bearerToken=null;
        return true;

    }

}