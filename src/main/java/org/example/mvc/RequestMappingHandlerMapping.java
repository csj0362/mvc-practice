package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMappingHandlerMapping implements HandlerMapping{
    private Map<HandlerKey, Controller> mapping = new HashMap<>();

    void init() {
       // mapping.put(new HandlerKey(RequestMethod.GET, "/"), new HomeController());
        mapping.put(new HandlerKey(RequestMethod.GET, "/users"), new UserListController());
        mapping.put(new HandlerKey(RequestMethod.POST, "/users"), new UserCreateController());
        mapping.put(new HandlerKey(RequestMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }

    // urlPath와 일치하는 핸들러 찾아줌
    public Controller findHandler(HandlerKey handlerKey) {
        return mapping.get(handlerKey);
    }
}
