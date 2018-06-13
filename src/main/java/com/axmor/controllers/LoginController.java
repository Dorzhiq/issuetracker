package com.axmor.controllers;


import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static com.axmor.util.RequestUtil.*;

public class LoginController {
     public static Route serveLoginPage = (Request request, Response response) -> {
         Map<String, Object> model = new HashMap<>();
         model.put("loggedOut", removeSessionAttrLoggedOut(request));
         model.put("loginRedirect", removeSessionAttrLoginRedirect(request));
         return ViewUtil.render(request, model, Path.Template.LOGIN);
     };

    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        if (!UserController.authenticate(getQueryUsername(request), getQueryPassword(request))) {
            model.put("authenticationFailed", true);
            return ViewUtil.render(request, model, Path.Template.LOGIN);
        }
        model.put("authenticationSucceeded", true);
        request.session().attribute("currentUser", getQueryUsername(request));
        if (getQueryLoginRedirect(request) != null) {
            response.redirect(getQueryLoginRedirect(request));
        }
        return ViewUtil.render(request, model, Path.Template.LOGIN);
    };
}
