package ru.yandex.startapp.web;

import ru.yandex.startapp.service.*;
import ru.yandex.startapp.domain.*;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/api")
public class MainController {

	@Autowired
	private MasterService masterService;
	@Autowired
	private TaskService taskService;	
	@Autowired
	private Validator validator;
	
	/*@Autowired
	@Qualifier("authenticationManager")
    private AuthenticationManager authManager;*/
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Master> mastersGetJSON() {
		List<Master> masters = masterService.listMaster();
		return masters;
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Task> tasksGetJSON() {
		List<Task> tasks = taskService.listTask();
		return tasks;
	}

	@RequestMapping(value = "/masters", method = RequestMethod.GET, produces = "application/json", params = "id")
	public @ResponseBody List<Task> tasksForMasterGetJSON(@RequestParam("id") String id) {
		List<Task> tasks = taskService.getTasksByMaster(masterService.getMasterById(Integer.parseInt(id)));
		return tasks;
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json", params = "id")
	public @ResponseBody Task getTaskById(@RequestParam("id") String id) {
		System.out.println("task " + id);
		Task task = taskService.getTaskById(Integer.parseInt(id));		
		return task;
	}

	@RequestMapping(value = "/master", method = RequestMethod.GET, produces = "application/json", params = "id")
	public @ResponseBody Master getMasterById(@RequestParam("id") String id) {
		Master master = masterService.getMasterById(Integer.parseInt(id));
		// System.out.println(task.getMaster().getName());
		return master;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public Task addTask(@RequestBody Task task) {	
		System.out.println(task.getBuilding());
		Set<ConstraintViolation<Task>> violations = validator.validate(task);

	    if (!violations.isEmpty()) {
	    	System.out.println("hello");
	        throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
	    }
		taskService.addTask(task);
		return task;
	}

	@RequestMapping(value = "/editTask", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = "application/json")
	@ResponseBody
	public Task editTask(@RequestBody Task task) {	
		Set<ConstraintViolation<Task>> violations = validator.validate(task);
		
		if (!violations.isEmpty()) {
	    	System.out.println("hello");
	        throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
	    }
		taskService.editTask(task);		
		return task;
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET, 
			produces = "application/json")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void login(@RequestBody Admin admin, HttpServletResponse response) {
		try {
			System.out.println("loginbefore" + admin.getUsername());
			SecurityContextHolder.getContext().setAuthentication(authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							admin.getUsername(), admin.getPassword())));			
			System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString());
		} catch(AuthenticationException e) {
			System.out.println("Auth exception" + e.toString());
		}
	}*/
	
}
