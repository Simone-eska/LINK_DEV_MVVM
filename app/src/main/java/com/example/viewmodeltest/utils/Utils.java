package com.example.viewmodeltest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

    public static String getDateFormat(String apiDate){
         SimpleDateFormat apiFormat = new SimpleDateFormat("yyyy-MM-dd");
         SimpleDateFormat viewFormat = new SimpleDateFormat("MMMM dd, yyyy");
        try {
            return viewFormat.format(apiFormat.parse(apiDate.substring(0,apiDate.indexOf("T"))));
        } catch (ParseException e) {
            return "";
        }
    }
}
