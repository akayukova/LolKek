package ru.yandex.startapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.yandex.startapp.dao.TaskDao;
import ru.yandex.startapp.domain.Master;
import ru.yandex.startapp.domain.Task;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao taskDao;

	@Transactional
	public void addTask(Task task) {
		taskDao.addTask(task);
	}

	@Transactional
	public List<Task> listTask() {
		return taskDao.listTask();
	}

	@Transactional
	public void removeTask(Integer id) {
		taskDao.removeTask(id);
	}

	@Transactional
	public void editTask(Task task) {
		taskDao.editTask(task);
	}

	@Transactional
	public Task getTaskById(Integer id) {
		return taskDao.getTaskById(id);
	}

	@Override
	@Transactional
	public List<Task> getTasksByMaster(Master master) {
		return taskDao.getTasksByMaster(master);
	}

}
