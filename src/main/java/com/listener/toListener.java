package com.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.entities.Todo;

public class toListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context created");
		List<Todo> todos=new ArrayList();
		ServletContext context=sce.getServletContext();
		context.setAttribute("todos", todos);
	}
}
