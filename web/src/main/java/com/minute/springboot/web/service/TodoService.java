package com.minute.springboot.web.service;

import com.minute.springboot.web.model.Todo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();

    private static int todoCount = 3;

    static {
        todos.add(new Todo(2, "superadmin", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(1, "superadmin", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "superadmin", "Learn Hibernate", new Date(), false));
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

    public List<Todo> addTodo(String name, String desc, Date targetDate) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, false));
        return todos;
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public List<Todo> addTodo(String name, String desc) {
        todos.add(new Todo(++todoCount, name, desc, new Date(), false));
        return retrieveTodos(name);
    }

    public Todo get(int todo) {
        for (Todo data : todos) {
            if (data.getId() == todo) {
                System.out.println(data);
                return data;
            }
        }
        return null;
    }

    public void update(Todo todo) {
        todos.forEach(data -> {
                    if (data.getId() == todo.getId()) {
                        data = todo;
                        System.out.println("updated");
                    }
                }
        );
    }
}
