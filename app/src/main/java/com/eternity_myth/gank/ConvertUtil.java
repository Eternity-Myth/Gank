package com.eternity_myth.gank;

public class ConvertUtil {
    public static String toString(Object value, String defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return String.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }


}


