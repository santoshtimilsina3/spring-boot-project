package com.minute.springboot.web.controller;

import com.minute.springboot.web.model.Todo;
import com.minute.springboot.web.service.LoginService;
import com.minute.springboot.web.service.TodoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("name", "mantosh");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome(@RequestParam String name, @RequestParam String pass, ModelMap modelMap, HttpSession session) {
        modelMap.put("name", name);
        modelMap.put("pass", pass);
        session.setAttribute("name", name);
        boolean response = loginService.validation(name, pass);
        return response ? "welcome" : "login";
    }

    @RequestMapping(value = "/todos-list", method = RequestMethod.GET)
    public String getValues(ModelMap modelMap, HttpSession session) {
        String user = (String) session.getAttribute("name");
        List<Todo> result = todoService.retrieveTodos(user);
        modelMap.put("data", result);
        boolean res = result.size() > 0;
        return res ? "todos-list" : "welcome";
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String todo(ModelMap modelMap, HttpSession session) {
        modelMap.addAttribute("todo", new Todo());
        return "todo";
    }

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    public String addTodo( ModelMap modelMap, HttpSession session, @Valid Todo todo,  BindingResult result) {
        System.out.println(result);
        if (result.hasErrors()) {
            return "todo";
        }
        String name = (String) session.getAttribute("name");
        System.out.println(todo.getDesc());
        List<Todo> todos = todoService.addTodo(name, todo.getDesc());
        return "redirect:/todos-list";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id, ModelMap modelMap, HttpSession session) {
        todoService.deleteTodo(id);
        return "redirect:/todos-list";

    }

}
