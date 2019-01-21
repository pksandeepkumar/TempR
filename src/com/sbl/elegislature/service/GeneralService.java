/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.service;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbl.elegislature.login.UserDetails;
import com.sbl.elegislature.models.pojo.assembly.GetActiveAssemblyPOJO;
import com.sbl.elegislature.models.pojo.businestype.GetAllBusinesTypePOJO;
import com.sbl.elegislature.models.pojo.group_member.GroupMemberPOJO;
import com.sbl.elegislature.models.pojo.grouptype.GroupTypePOJO;
import com.sbl.elegislature.models.pojo.language.GetAllLanguagePOJO;
import com.sbl.elegislature.models.pojo.members.GetAllMembersPOJO;
import com.sbl.elegislature.models.pojo.reporterusers.GetAllUsersPOJO;
import com.sbl.elegislature.models.pojo.save_group.SaveGroupResponsePOJO;
import com.sbl.elegislature.models.pojo.session.GetAllSessionsPOJO;
import com.sbl.elegislature.models.pojo.sessiondate.GetAllSessionDatePOJO;
import com.sbl.elegislature.models.pojo.timeslots.GetAllTimeSlotsPOJO;
import com.sbl.elegislature.models.pojo.user.GetCurrentUserPOJO;
import static com.sbl.elegislature.util.AppContext.APPLICATION_PROPERTIES;
import static com.sbl.elegislature.util.AppContext.serviceClient;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
public class GeneralService {

    private static class GeneralServiceProvider {

        private static final GeneralService GENERAL_SERVICE_INSTANCE = new GeneralService();
    }

    public static GeneralService generalServiceInstance() {
        return GeneralServiceProvider.GENERAL_SERVICE_INSTANCE;
    }

    private GeneralService() {

    }

    //Methods to get and post
//    public List getAssembly() {
//        List response = new ArrayList();
//        try {
//            String getResponse = serviceClient().doGetRequest(APPLICATION_PROPERTIES.getProperty("assemblySessionUrl"));
//            response = new ObjectMapper().readValue(getResponse, ArrayList.class);
//        } catch (Exception e) {
//            e.printStackTrace(System.err);
//        }
//        return response;
//    }
    public List getGroup() {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest("reporter/get-reporter-group");
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public GetCurrentUserPOJO getCurrentUserInfo() {
        try {
            String getResponse = serviceClient().doGetRequest("user/get-current-user");
            GetCurrentUserPOJO respObject = new ObjectMapper().readValue(getResponse, GetCurrentUserPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public List getGroupType() {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest("reporter/get-reporter-group-type");
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public List getLanguage() {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest("language/getlanguages");
            System.out.println("Languages :   \n" + getResponse);
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public List getAssembly() {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest("assembly/get-all-assemblies");
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }
    
    
    

    public GetActiveAssemblyPOJO getAssemblyPojo() {
        try {
            String getResponse = serviceClient().doGetRequest("assembly/get-all-assemblies?isActive=true");
            GetActiveAssemblyPOJO respObject = new ObjectMapper().readValue(getResponse, GetActiveAssemblyPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public GetAllSessionsPOJO getAllSessionPojo(int assemblyId) {
        try {
            String getResponse = serviceClient().doGetRequest("session/get-all-sessions?assemblyId=" + assemblyId);
            GetAllSessionsPOJO respObject = new ObjectMapper().readValue(getResponse, GetAllSessionsPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public GetAllUsersPOJO getAllUsers() {
        try {
            String getResponse = serviceClient().doGetRequest("reporter/get-all-users-under-reporter/RA");
            GetAllUsersPOJO respObject = new ObjectMapper().readValue(getResponse, GetAllUsersPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    
    public GroupMemberPOJO getGroupMemberPOJO(int sessionDateId) {
        try {
            String getResponse = serviceClient()
                    .doGetRequest("reporter/get-reporter-group-members?sessionDateId=" + sessionDateId);
            GroupMemberPOJO respObject = new ObjectMapper().readValue(getResponse, GroupMemberPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public GetAllSessionDatePOJO getAllSessionDate(int sessionId) {
        try {
            String getResponse = serviceClient().doGetRequest("sessiondate/get-all-sessiondates?sessionId=" + sessionId);
            GetAllSessionDatePOJO respObject = new ObjectMapper().readValue(getResponse, GetAllSessionDatePOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    public GetAllLanguagePOJO getAllLanguages() {
        try {
            String getResponse = serviceClient().doGetRequest("language/getlanguages");
            GetAllLanguagePOJO respObject = new ObjectMapper().readValue(getResponse, GetAllLanguagePOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public GroupTypePOJO getGroupTypePojo() {
        try {
            String getResponse = serviceClient().doGetRequest("reporter/get-reporter-group-type");
            GroupTypePOJO respObject = new ObjectMapper().readValue(getResponse, GroupTypePOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public GetAllMembersPOJO getAllMembers() {
        try {
            String getResponse = serviceClient().doGetRequest("member-assembly/get-all-members");
            GetAllMembersPOJO respObject = new ObjectMapper().readValue(getResponse, GetAllMembersPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public GetAllBusinesTypePOJO getBusinessType() {
        try {
            String getResponse = serviceClient().doGetRequest("business-type/get-buiness-type");
            GetAllBusinesTypePOJO respObject = new ObjectMapper().readValue(getResponse, GetAllBusinesTypePOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public GetAllTimeSlotsPOJO getAllTimeSlots(int sessionId) {
        try {
            String getResponse = serviceClient().doGetRequest("reporter/get-slot-list?sessionDateId=" + sessionId);
            GetAllTimeSlotsPOJO respObject = new ObjectMapper().readValue(getResponse, GetAllTimeSlotsPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    
    public Object saveGroup(int assemblyId) {
        try {
            String getResponse = serviceClient().doGetRequest("session/get-all-sessions?assemblyId=" + assemblyId);
            GetAllSessionsPOJO respObject = new ObjectMapper().readValue(getResponse, GetAllSessionsPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    
    

    public List getSession() {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest("session/get-all-sessions");
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public GetActiveAssemblyPOJO getAllSessionsPojo() {
        try {
            String getResponse = serviceClient().doGetRequest("assembly/get-all-assemblies?isActive=true");
            GetActiveAssemblyPOJO respObject = new ObjectMapper().readValue(getResponse, GetActiveAssemblyPOJO.class);
            return respObject;
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return null;
    }
    
    public SaveGroupResponsePOJO saveGroupMember(String json) {
        try {
            String getResponse = serviceClient().doPostRequest("reporter/save-group-and-employee", json);
            SaveGroupResponsePOJO response = new ObjectMapper().readValue(getResponse, SaveGroupResponsePOJO.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getSessionDate() {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest("sessiondate/get-all-sessiondates");
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public List getEmployeeList(int department_id) {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest(MessageFormat.format("user/get-all-employee-by-department?id={0}", 6));
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public List getReporterList(int session_date_id) {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest(MessageFormat.format("reporterhierarchy/get-group-hierarchy?id={0}", 2));
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public List getSlotsList(int session_date_id) {
        HashMap response = new HashMap();
        try {
            String getResponse = serviceClient().doGetRequest(MessageFormat.format("reporter/get-time-slot-list?id={0}", 2));
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        List responseList = (List) response.get("data");
        return responseList;
    }

    public int saveSlotList(String json) {
        HashMap response = new HashMap();

        try {
            String getResponse = serviceClient().doPostRequest("reporter/save-slot-list", json);
            System.out.println("--------Save Responce-------");
            System.out.println(getResponse);
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response.get("message").equals("DATA SAVED SUCCESSFULY")) {
            return 1;
        } else {
            return -1;
        }
    }

    public int saveHierarchy(String json) {
        HashMap response = new HashMap();

        try {
            String getResponse = serviceClient().doPostRequest("reporterhierarchy/save-group-hierarchy", json);
            System.out.println("--------Save Responce-------");
            System.out.println(getResponse);
            response = new ObjectMapper().readValue(getResponse, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (response.get("message").equals("DATA SAVED SUCCESSFULY")) {
            return 1;
        } else {
            return -1;
        }
    }

    public Boolean doLogin(String userName, String passWord) {
        HashMap response = new HashMap();
        Boolean doPostRequest = false;
        try {

            doPostRequest = serviceClient().doPostLoginRequest(userName, passWord);

        } catch (Exception e) {
            System.out.println("Unable to parse the response : " + e.getLocalizedMessage());
        }
        if (doPostRequest) {
            return true;
        } else {
            return false;
        }

    }

    public Boolean doLogout() {
        Boolean doPostRequest = false;
        try {

            doPostRequest = serviceClient().doPostLogOutRequest();

        } catch (Exception e) {
            System.out.println("Unable to parse the response : " + e.getLocalizedMessage());
        }
        if (doPostRequest) {
            return true;
        } else {
            return false;
        }

    }

//    public String userLogin()
//    {
//            HashMap response =new HashMap();
//            String json=null;
//       
//       try{
//                
//           FormBody.Builder formBuilder = new FormBody.Builder();
//         formBuilder.add("username","admin");
//         formBuilder.add("password","password");
//          ObjectMapper mapper = new ObjectMapper();
//         //UserDetails userdetails=new UserDetails();
//         Map map=new HashMap<String,String>();
//         map.put("username","admin");
//         map.put("password :","password");
//         json=mapper.writeValueAsString(map);//mapper.convertValue(map, String.class);
//     //    json="{\"username\":\"admin\",\"password \":\"password\"}";
//           String getResponse=null;//serviceClient().doLoginRequest("/oauth/token", json);
//           System.out.println("--------Login Responce-------");
//           System.out.println(getResponse);
//           response = new ObjectMapper().readValue(getResponse, HashMap.class);
//           if(response!=null){
//           if(response.containsKey("access_token"))          
//           {
//              if(response.get("access_token")!=null)
//                       return (String) response.get("access_token");
//                   else
//                       return null;
//              
//                     
//                  
//              
//           }
//       }
//       }
//       catch(Exception e)
//       {
//           e.printStackTrace();
//       }
//       return null;
//    }
}
