package ru.yandex.startapp.service;

import java.util.List;

import ru.yandex.startapp.domain.Master;
import ru.yandex.startapp.domain.Task;

public interface TaskService {
	
	public void addTask(Task task);
	
	public Task getTaskById(Integer taskId);

	public List<Task> listTask();

	public void removeTask(Integer id);
	
	public void editTask(Task task);
	
	public List<Task> getTasksByMaster(Master master);
}
