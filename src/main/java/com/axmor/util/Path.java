package com.axmor.util;

public class Path {
    public static class Web {
        public static final String ISSUES = "/issues/";
        public static final String ISSUE_BY_ID = "/task/:issueId/";
        public static final String PUT_ISSUE = "/issue/:issueId/";
        public static final String POST_ISSUE = "/issues/add/";
        public static final String CREATE_ISSUE = "/issues/create/";
        public static final String DELETE_ISSUE = "/issues/delete/:issueId/";
        public static final String LOGIN = "/login/";
        public static final String LOGOUT = "/logout/";
        public static final String POST_COMMENT = "/issue/:issueId/comments/";

        public static String getLOGIN() {
            return LOGIN;
        }

        public static String getLOGOUT() {
            return LOGOUT;
        }

        public static String getISSUES() {
            return ISSUES;
        }
    }
    public static class Template {
        public final static String ISSUES_ALL = "/velocity/issue/all.vm";
        public final static String ISSUE_BY_ID = "/velocity/issue/issueById.vm"; //написать issueById.vm
        public final static String CREATE_ISSUE = "/velocity/issue/create.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
    }
}
