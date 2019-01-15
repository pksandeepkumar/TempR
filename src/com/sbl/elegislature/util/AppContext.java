/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

import com.sbl.elegislature.service.ServiceClient;
import com.sbl.elegislature.service.ServiceClientImpl;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author Surya Anand <surya.anand@sblsoftware.com>
 */
/**
 * Global application state.
 */
public final class AppContext {

    public static String USER_REPORTER = "";
    public static String USER_EDITOR = "";
    public static String USER_DEPUTY_EDITOR = "";
    public static String USER_JOINT_CHIEF_EDITOR = "";
    public static String USER_CHIEF_EDITOR = "CHIEF_EDITOR";
    public static String USER_SECRETARY = "";
    public static String USER_SPEAKER = "";

    public static String BASE_URL = "";

    public static final Properties APPLICATION_PROPERTIES = new Properties();

    public String userType = null;
    public int employeeId = 0;
    public int userId = 0;
    public static int selectedAssemblyId;
    public static int selectedSessionId;
    public static int selectedSessionDateId;
    public static int selectedLanguageId;

    //  public static String JSESSIONID = "";
    //   public static String MAC_ADDRESS = "";
    private static final class ApplicationHolder {

//        private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(APPLICATION_PROPERTIES.getProperty("resourceBundleBaseName"));
        private static final ServiceClient SERVICE_CLIENT = new ServiceClientImpl();
        private static final AppContext INSTANCE = new AppContext();

    }

    public static AppContext application() {
        return ApplicationHolder.INSTANCE;
    }

    public static ServiceClient serviceClient() {
        return ApplicationHolder.SERVICE_CLIENT;
    }

    public void loadProperties() {
        String propFileName = "config.properties";
        try {
//                APPLICATION_PROPERTIES.load(inputStream);
            APPLICATION_PROPERTIES.load(new FileInputStream(propFileName));

            USER_REPORTER = APPLICATION_PROPERTIES.getProperty("reporter");
            USER_EDITOR = APPLICATION_PROPERTIES.getProperty("editor");
            USER_DEPUTY_EDITOR = APPLICATION_PROPERTIES.getProperty("deputyEditor");
            USER_JOINT_CHIEF_EDITOR = APPLICATION_PROPERTIES.getProperty("jointChiefEditor");
            USER_CHIEF_EDITOR = APPLICATION_PROPERTIES.getProperty("chiefEditor");
            USER_SECRETARY = APPLICATION_PROPERTIES.getProperty("secretary");
            USER_SPEAKER = APPLICATION_PROPERTIES.getProperty("speaker");

            BASE_URL = APPLICATION_PROPERTIES.getProperty("baseUrl");

        } catch (Exception e) {
            System.err.println("property file '" + propFileName + "' not found in the classpath");
            e.printStackTrace();
        }

    }

//    public static ResourceBundle resources() {
//        return ApplicationHolder.RESOURCE_BUNDLE;
//    }
//    static {
//        try {
//            APPLICATION_PROPERTIES.load(AppContext.class.getResourceAsStream("/speakerpad-application.properties"));
//        } catch (IOException ex) {
//            ex.printStackTrace(System.err);
//        }
//    }
}
