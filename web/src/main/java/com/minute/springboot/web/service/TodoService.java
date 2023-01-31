package com.minute.springboot.web.service;

import com.minute.springboot.web.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(2, "in28Minutes", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(1, "in28Minutes", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> userTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                userTodos.add(todo);
            }
        }
        return userTodos;
    }

    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.forEach(todo -> {
            if (todo.getId() == id) {
                todos.remove(todo);
            }
        });
    }
}
