package com.axmor.controllers;

import com.axmor.issue.Comment;
import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.*;

import static com.axmor.Main.issueDao;
import static com.axmor.util.JsonUtil.dataToJson;
import static com.axmor.util.JsonUtil.parseJson;
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
        if (issueDao.getById(Long.valueOf(request.params(":issueId"))) != null) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("issueById", issueDao.getById(Long.valueOf(request.params(":issueId"))));
            model.put("comments", issueDao.getCommentsById(Long.valueOf(request.params(":issueId"))));
            return ViewUtil.render(request, model, Path.Template.ISSUE_BY_ID);
        } else {
            return ViewUtil.notAcceptable.handle(request, response);
        }
    };

    public static Route putIssue = (Request request, Response response) -> {
        long id = Long.valueOf(request.params(":issueId"));
        String author = parseJson(request.body(), "author");
        String status = parseJson(request.body(), "status");
        issueDao.patchIssue(id, author, status);
        return dataToJson("Issue with id " + id + " is updated!");
    };

    public static Route postIssue = (Request request, Response response) -> {
        String name = parseJson(request.body(), "name");
        String author = parseJson(request.body(), "author");
        String description = parseJson(request.body(), "description");
        String status = parseJson(request.body(), "status");
        List<Comment> comments = new LinkedList<>();
        issueDao.postIssue(name, author, description, status, comments);
        return dataToJson("New issue " + name + " is added!");
    };

    public static Route fetchCreate = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        HashMap<String, Object> model = new HashMap<>();
        return ViewUtil.render(request, model, Path.Template.CREATE_ISSUE);
    };

    public static Route postComment = (Request request, Response response) -> {
        long id = Long.valueOf(request.params(":issueId"));
        String author = parseJson(request.body(), "authorComment");
        String status = parseJson(request.body(), "statusComment");
        String text = parseJson(request.body(), "textComment");
        issueDao.postComment(id, author, status, text);
        return dataToJson("New comment" + text + " is added!");
    };

//    public static Route deleteIssue = (Request request, Response response) -> {
//        long id = Long.valueOf(request.params(":issueId"));
//        issueDao.deleteIssue(id);
//        return dataToJson("Issue with id " + id + " is deleted!");
//    };
}
