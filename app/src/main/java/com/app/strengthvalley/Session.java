package com.app.strengthvalley;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.strengthvalley.Classes.User;
//import android.os.Build;
//import android.util.Log;
//import java.net.HttpURLConnection;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;


public class Session{
    //    private static final String VERSION = "5000";
    private static Session instance;
    private static Context app;
    public static final long GCM_REFRESH_TOKEN_TIME = 12 * 60 * 60 * 1000;
    public static final String GCM_LAST_SERVER_UPDATE = "gcm.last.server.update";
    public String sessionId;
    public String token;
    public String deviceId;
    public String sessionCounter;

    private User user;

    public int appVersionForFcm;
    public String fcmToken;
    public long lastFcmUpdate;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean setPushToken(String gcmToken) {
        String oldGcmToken = getSharedPreferences().getString("FCMToken", null);
        if (gcmToken.equals(oldGcmToken))
            return false;

        getSharedPreferences().edit().putString("FCMToken", gcmToken).commit();
        return true;
    }

    public boolean setGcmLastServerUpdate(long gcmLastServerUpdate) {
        return getSharedPreferences().edit().putLong(GCM_LAST_SERVER_UPDATE, gcmLastServerUpdate).commit();
    }

    private Session() {
        SharedPreferences sp = getSharedPreferences();
        deviceId = sp.getString("deviceId", null);
        sessionId = sp.getString("sessionId", null);
        token = sp.getString("token", null);
        sessionCounter = sp.getString("sessionCounter", "0");
        fcmToken = sp.getString("fcmToken", null);
        lastFcmUpdate = sp.getLong("lastFcmUpdate", 0);
        appVersionForFcm = sp.getInt("appVersionForFcm", 0);

    }


    public SharedPreferences getSharedPreferences() {
        return app.getSharedPreferences("session", Context.MODE_PRIVATE);
    }


    public boolean isLoggedIn() {
        return sessionId != null && token != null;
    }


    public void validateVersionFcm(int version) {
        appVersionForFcm = version;
        getSharedPreferences().edit()
                .putInt("appVersionForFcm", appVersionForFcm)
                .commit();
    }


    public void setFcmToken(String fcmToken) {
        if(this.fcmToken != null && !this.fcmToken.equals(fcmToken)) {
            lastFcmUpdate = 0;
            getSharedPreferences().edit().putLong("lastFcmUpdate", lastFcmUpdate).commit();
        }
        this.fcmToken = fcmToken;
        getSharedPreferences().edit().putString("fcmToken", this.fcmToken).commit();
    }

    public void validateFcmToken() {
        this.lastFcmUpdate = System.currentTimeMillis();
        getSharedPreferences().edit().putLong("lastFcmUpdate", lastFcmUpdate).commit();
    }

    public boolean shouldSendFcmToken() {
        boolean result = deviceId != null && isLoggedIn() && fcmToken != null && System.currentTimeMillis() - lastFcmUpdate > 4 * 60 * 60 * 1000;
        return result;
    }

    public void login(String sessionId, String token, String employeeName, String employeeId, String deviceId, String loggedInUser) {
        this.sessionId = sessionId;
        this.token = token;
        this.deviceId = deviceId;
        this.sessionCounter = "0";

        getSharedPreferences().edit()
                .putString("sessionId", sessionId)
                .putString("token", token)
                .putString("employeeName", employeeName)
                .putString("employeeId", employeeId)
                .putString("sessionCounter", sessionCounter)
                .putString("deviceId",deviceId)
                .putString("loggedInUser",loggedInUser)
                .commit();
    }




    public void logout() {
        deviceId = null;
        sessionId = null;
        token = null;

        getSharedPreferences().edit()
                .remove("sessionId")
                .remove("token")
                .remove("employeeName")
                .remove("employeeId")
                .remove("sessionCounter")
                .remove("deviceId")
                .remove("loggedInUser")
                .commit();

    }

    public String getSessionCounter() {
        return sessionCounter;
    }



    public boolean shouldUpdateToken() {
        long lastServerTime = getSharedPreferences().getLong(GCM_LAST_SERVER_UPDATE, -1);
        return lastServerTime == -1 || (System.currentTimeMillis() - lastServerTime) > GCM_REFRESH_TOKEN_TIME;
    }

    public static Session init(Context context) {
        app = context;
        instance = new Session();
        return instance;
    }

    public static Session get() {
        return instance;
    }


}