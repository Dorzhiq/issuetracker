package com.axmor.util;

import spark.Request;

public class RequestUtil {
    public static boolean clientAcceptsHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }
    public static boolean clientAcceptsJson(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("application/json");
    }
    public static String getSessionLocale(Request request) {
        return request.session().attribute("locale");
    }

}
