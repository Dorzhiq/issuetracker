package com.axmor;


import com.axmor.controllers.IssueController;
import com.axmor.controllers.LoginController;
import com.axmor.dao.IssueDao;
import com.axmor.dao.UserDao;
import com.axmor.issue.Issue;
import com.axmor.util.Path;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * Application entry point
 */
public class Main {
    public static IssueDao issueDao = new IssueDao();
    public static UserDao userDao = new UserDao();
    public static SessionFactory sessionFactory = buildSessionFactory(Issue.class);
    public static void main(String[] args) {
        port(8080);
        get("/", (Request req, Response res) -> "<html><body><h1>Hello, world!</h1></body></html>");
        get(Path.Web.ISSUES, IssueController.fetchAllIssues);
        get(Path.Web.ISSUE_BY_ID, IssueController.fetchIssueById);
        put(Path.Web.PUT_ISSUE, IssueController.putIssue);
        post(Path.Web.POST_ISSUE, IssueController.postIssue);
        get(Path.Web.CREATE_ISSUE, IssueController.fetchCreate);
//        delete(Path.Web.DELETE_ISSUE, IssueController.deleteIssue);

        get(Path.Web.LOGIN, LoginController.serveLoginPage);
        post(Path.Web.LOGIN, LoginController.handleLoginPost);
        post(Path.Web.LOGOUT, LoginController.handleLogoutPost);
    }
    private static SessionFactory buildSessionFactory(Class... clazzs) {
         Configuration config = new Configuration().configure();
         for(Class clazz:clazzs){
             config.addAnnotatedClass(clazz);
         }
         return config.buildSessionFactory();
    }
}
