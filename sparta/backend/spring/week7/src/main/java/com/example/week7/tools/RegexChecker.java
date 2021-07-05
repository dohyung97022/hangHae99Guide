package com.example.week7.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChecker {
    public static final String idRegex = "[a-zA-Z0-9]{3,}";
    public static final String pwRegex = ".{4,}";

    public static boolean check(String str, String rgx){
        Pattern p = Pattern.compile(rgx);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static String getContainsRegex(String str){
        return "^.*"+str+".*$";
    }
}
