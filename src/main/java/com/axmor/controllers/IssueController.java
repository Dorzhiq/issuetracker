package com.axmor.controllers;

import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static com.axmor.Main.issueDao;
import static com.axmor.util.JsonUtil.dataToJson;
import static com.axmor.util.RequestUtil.clientAcceptsHtml;
import static com.axmor.util.RequestUtil.clientAcceptsJson;

public class IssueController {

    public static Route fetchAllIssues = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)){
            HashMap<String, Object> model = new HashMap<>();
            model.put("issues", issueDao.getAllIssues());
            return ViewUtil.render(request, model, Path.Template.ISSUES_ALL);
        }
        if (clientAcceptsJson(request)){
            return dataToJson(issueDao.getAllIssues());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route fetchIssueById = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (issueDao.getById(request.params(":issueId"))!=null) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("issueById", issueDao.getById(request.params(":issueId")));
            return ViewUtil.render(request, model, Path.Template.ISSUE_BY_ID);
        } else return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route putIssue = (Request request, Response response) -> {
        String id = request.params(":issueId");
        String author = request.queryParams("author");
        String status = request.queryParams("status");
        issueDao.patchIssue(id, author, status);
        return dataToJson("Issue with id " + id + "is updated!");
    };

    public static Route postIssue = (Request request, Response response) -> {
        String name = parseJson(request.body(), "name");
        String author = parseJson(request.body(), "author");
        String description = parseJson(request.body(), "description");
        String status = parseJson(request.body(), "status");
        issueDao.postIssue(name, author, description, status);
        return dataToJson("New issue " + name + " is added!");
    };

    public static Route fetchCreate = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        HashMap<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.CREATE_ISSUE);
    };

//    public static Route deleteIssue = (Request request, Response response) -> {
//        String id = request.params(":issueId");
//        issueDao.deleteIssue(id);
//        return dataToJson("Issue with id " + id + " is deleted!");
//    };
}
