package ru.yandex.startapp.service;

import java.util.List;

import ru.yandex.startapp.domain.Task;

public interface TaskService {
	
	public void addTask(Task task);

	public List<Task> listTask();

	public void removeTask(Integer id);
}
