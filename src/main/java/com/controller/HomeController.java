package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Todo;

@Controller
public class HomeController {
	@Autowired
	ServletContext context;
	
	@RequestMapping("/Home")
	public String home(Model m) {
		String str="Home";
		m.addAttribute("page",str);
		List<Todo> todos=(ArrayList<Todo>) context.getAttribute("todos");
		m.addAttribute("todos", todos);
		return "Home";
	}
	
	@RequestMapping("/add")
	public String addTodo(Model m) {
		Todo todo=new Todo();	
		m.addAttribute("page", "add");
		m.addAttribute("todo", todo);
		return "Home";
	}
	
	@RequestMapping(value="/saveTodo", method = RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo todo, Model m) {
		todo.setTodoDate(new Date());
		//getting todo list from context
		List<Todo> todos=(ArrayList<Todo>) context.getAttribute("todos");
		todos.add(todo);
		m.addAttribute("msg", "successfully added");
		return "Home";
	}
}
