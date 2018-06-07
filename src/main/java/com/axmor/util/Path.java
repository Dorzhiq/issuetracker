package com.axmor.util;

public class Path {
    public static class Web {
        public static final String ISSUES = "/issues/";

        public static String getISSUES() {
            return ISSUES;
        }
    }
    public static class Template {
        public final static String ISSUES_ALL = "/velocity/issue/all.vm";
    }
}
