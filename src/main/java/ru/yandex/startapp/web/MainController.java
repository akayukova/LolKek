package ru.yandex.startapp.web;

import ru.yandex.startapp.service.*;
import ru.yandex.startapp.domain.*;

import org.springframework.http.HttpStatus;
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

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("")
public class MainController {

	@Autowired
	private MasterService masterService;
	@Autowired
	private TaskService taskService;

	@RequestMapping("/home")
	public String main(Model ui) {
		System.out.println("main");
		ui.addAttribute("newTask", new Task());
		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String taskListGet(Model ui) {
		ui.addAttribute("newTask", new Task());

		return "index";
	}

	@RequestMapping(value = "index/form", method = RequestMethod.POST)
	public String taskListPost(Task task, BindingResult br, Model ui) {
		// System.out.println(br.toString() + "BR ");
		// System.out.println(task.toString() + "task ");
		taskService.addTask(task);
		ui.addAttribute("newTask", task);
		return "service";
	}

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String masterListGet(Model ui) {
		ui.addAttribute("newMaster", new Master());
		System.out.println("masterListGet");

		return "service";
	}

	// returns JSON!!!
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Master> mastersGetJSON(/* @PathVariable String id */) {
		List<Master> masters = masterService.listMaster();
		return masters;
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Task> tasksGetJSON(/* @PathVariable String id */) {
		List<Task> tasks = taskService.listTask();
		return tasks;
	}

	@RequestMapping(value = "/masters", method = RequestMethod.GET, produces = "application/json", params = "id")
	public @ResponseBody List<Task> tasksForMastersGetJSON(@RequestParam("id") String id) {
		List<Task> tasks = taskService.getTasksByMaster(masterService.getMasterById(Integer.parseInt(id)));
		return tasks;
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json", params = "id")
	public @ResponseBody Task getTaskById(/* @PathVariable String id */ @RequestParam("id") String id) {
		Task task = taskService.getTaskById(Integer.parseInt(id));
		// System.out.println(task.getMaster().getName());
		return task;
	}

	@RequestMapping(value = "/master", method = RequestMethod.GET, produces = "application/json", params = "id")
	public @ResponseBody Master getMasterById(/* @PathVariable String id */ @RequestParam("id") String id) {
		Master master = masterService.getMasterById(Integer.parseInt(id));
		// System.out.println(task.getMaster().getName());
		return master;
	}

	@RequestMapping(value = "/test2", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	@ResponseBody
	public Task addTask(@RequestBody Task task) {
		// logger.debug(task.toString());
		taskService.addTask(task);
		return task;
	}

	@RequestMapping(value = "/editTask", method = RequestMethod.POST, headers = {
			"Content-type=application/json" }, produces = "application/json")
	@ResponseBody
	public Task editTask(@RequestBody Task task) {
		// logger.debug(task.toString());
		taskService.editTask(task);
		/*
		 * task = taskService.getTaskById(task.getTaskId());
		 * System.out.println(task.getMaster().getName());
		 */
		return task;
	}

	/*
	 * @RequestMapping(value = "service/form", method = RequestMethod.POST) public
	 * String masterListPost(Master master, BindingResult br, Model ui) {
	 * System.out.println(br.toString() + "BR ");
	 * System.out.println(master.toString() + "task ");
	 * 
	 * masterService.addMaster(master);
	 * 
	 * ui.addAttribute("newMaster", master);
	 * 
	 * return "service";
	 */
}
