package com.example.suhussai.as1.controller;

import android.content.Context;

/**
 * Created by suhussai on 27/01/16.
 */
public class AppControllerHandler {
    private static AppController appController = null;

    public static AppController getAppController(Context base){
        if (appController == null) {
            appController = new AppController(base);
        }
        return appController;
    }
}
