package com.axmor;


import com.axmor.controllers.IssueController;
import com.axmor.dao.IssueDao;
import com.axmor.issue.Issue;
import com.axmor.util.Path;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.Request;
import spark.Response;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Application entry point
 */
public class Main {
    public static IssueDao issueDao;
    public static void main(String[] args) {
        Issue issue = new Issue("task1", "dorzhi", "created");

        SessionFactory sessionFactory = buildSessionFactory(Issue.class);

        Session session = sessionFactory.openSession();

        session.save(issue);

        issueDao = new IssueDao();

        port(8080);


        get("/", (Request req, Response res) -> "<html><body><h1>Hello, world!</h1></body></html>");
        get(Path.Web.ISSUES, IssueController.fetchAllIssues);

        session.close();
        sessionFactory.close();
    }
    private static SessionFactory buildSessionFactory(Class clazz) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }
}
