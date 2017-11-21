package ru.yandex.startapp.dao;
import ru.yandex.startapp.domain.Task;
import java.util.List;


public interface TaskDao {
	
	public void addTask(Task task);

	public List<Task> listTask();

	public void removeTask(Integer id);

}
