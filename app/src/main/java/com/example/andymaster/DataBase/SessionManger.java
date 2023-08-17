package com.example.andymaster.DataBase;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManger {
    SharedPreferences users_Session;
    SharedPreferences.Editor editor;
    Context context;

    // Login Session
    public   final  static String User_Session = "UserLogginSession";

    public final static String Is_Login = "IsLoggedIn";

    public static  String Key_FullName = "FullName";

    public static  String Key_email = "Email";
    public static  String Key_password = "password";

    public static  String Key_Profile_pic = "profile_pic";

    public static final String Key_Score = "Score";

    public SessionManger(Context Context, String user_Session ) {
        users_Session = context.getSharedPreferences(User_Session, Context.MODE_PRIVATE);
        editor = users_Session.edit();
    }
    public int setQuizScore(long score) {
        // You can implement this method to save the quiz score for the user.
        // For example, you can add the score to the current saved score.
        int currentScore = users_Session.getInt(Key_Score, 0);
        long newScore = currentScore + score;
        editor.putInt(Key_Score, (int) newScore);
        editor.apply();
        return currentScore;
    }

    public void LoginSession(String name, String email,String password) {
        editor.putBoolean(Is_Login, true);
        editor.putString(Key_FullName, name);
        editor.putString(Key_email, email);
        editor.putString(Key_password, password);
        editor.commit();
    }

    public HashMap<String, String> getuserDetialsFromSession() {
        HashMap<String, String> userdata = new HashMap<>();
        userdata.put(Key_FullName, users_Session.getString(Key_FullName, null));
        userdata.put(Key_email, users_Session.getString(Key_email, null));
        return userdata;

    }

    public HashMap<String, String> UpdateserDetials() {
        HashMap<String, String> userdata = new HashMap<>();
        userdata.put(Key_FullName, users_Session.getString(Key_FullName, null));
        userdata.put(Key_email, users_Session.getString(Key_email, null));
        userdata.put(Key_password, users_Session.getString(Key_password, null));
        return userdata;

    }

    public boolean CheckLogin() {
        if (users_Session.getBoolean(Is_Login, false)) {
            return true;
        } else {
            return false;
        }
    }

    public void LogoutUserFromSession() {
        editor.clear();
        editor.commit();
    }

}
