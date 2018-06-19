package com.axmor.controllers;

import com.axmor.util.Path;
import com.axmor.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static com.axmor.Main.userDao;

public class IndexController {
    public static Route fetchIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("users", userDao.getAllUsername());
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}
