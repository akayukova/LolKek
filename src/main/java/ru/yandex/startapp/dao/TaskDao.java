package ru.yandex.startapp.dao;
import ru.yandex.startapp.domain.Master;
import ru.yandex.startapp.domain.Task;
import java.util.List;


public interface TaskDao {
	
	public void addTask(Task task);

	public List<Task> listTask();

	public void removeTask(Integer id);
	
	public void editTask(Task task);
	
	public Task getTaskById(Integer taskId);
	
	public List<Task> getTasksByMaster(Master master);	
	

}
