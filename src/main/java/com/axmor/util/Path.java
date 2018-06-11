package com.axmor.util;

public class Path {
    public static class Web {
        public static final String ISSUES = "/issues/";
        public static final String ISSUE_BY_ID = "/:issueId/";
        //public static final String PUT_ISSUE = "/issue/:issueId";

        public static String getISSUES() {
            return ISSUES;
        }
    }
    public static class Template {
        public final static String ISSUES_ALL = "/velocity/issue/all.vm";
        public final static String ISSUE_BY_ID = "/velocity/issue/issueById.vm"; //написать issueById.vm
        //public final static String PUT_ISSUE = "/velocity/issue/put_issue.vm"; //написать put_issue.vm
    }
}
