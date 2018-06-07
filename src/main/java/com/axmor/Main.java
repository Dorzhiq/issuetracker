package com.axmor;


import com.axmor.controllers.IssueController;
import com.axmor.dao.IssueDao;
import com.axmor.util.Path;
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

        issueDao = new IssueDao();

        port(81);


        get("/", (Request req, Response res) -> "<html><body><h1>Hello, world!</h1></body></html>");
        get(Path.Web.ISSUES, IssueController.fetchAllIssues);


    }
}
