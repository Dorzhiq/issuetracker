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
        HashMap<String, Object> model = new HashMap<>();
        model.put("issueById", issueDao.getById(request.params(":issueId")));
        return ViewUtil.render(request, model, Path.Template.ISSUE_BY_ID);
    };
    // тут пут
//    public static Route putIssue = (Request request, Response response) -> {
////        HashMap<String, Object> model =  new HashMap<>();
////        model.put("putIssueById", issueDao.patchIssue(request.params(":issueId")));//где используется первый аргумент?
////        return ViewUtil.render(request, model, Path.Template.PUT_ISSUE);
////    };
}
