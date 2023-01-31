package com.minute.springboot.web.controller;

import com.minute.springboot.web.model.Todo;
import com.minute.springboot.web.service.LoginService;
import com.minute.springboot.web.service.TodoService;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login( ModelMap modelMap) {
        modelMap.put("name", "mantosh");
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome(@RequestParam String name, @RequestParam String pass, ModelMap modelMap) {
        modelMap.put("name", name);
        modelMap.put("pass", pass);
      boolean response =  loginService.validation(name,pass);
        return response ? "welcome" : "login";
    }

    @RequestMapping(value = "/todos-list", method = RequestMethod.GET)
    public String getValues(ModelMap modelMap){
       List<Todo> result = todoService.retrieveTodos("in28Minutes");
       modelMap.put("data",result);
       boolean res = result.size() > 0;
        return res ?"todos-list": "welcome";
    }
}
