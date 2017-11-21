package ru.yandex.startapp.dao;

import java.util.List;
import ru.yandex.startapp.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TaskDaoImpl implements TaskDao{

	@Autowired
	private SessionFactory sessionFactory;
		
	public void addTask(Task task) {
		Session tmpSession = sessionFactory.getCurrentSession();
		tmpSession.save(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> listTask() {
		return sessionFactory.getCurrentSession().createQuery("from Task")
				.list();
	}

	@Override
	public void removeTask(Integer id) {
		Task task = (Task) sessionFactory.getCurrentSession().load(
				Task.class, id);
		if (null != task) {
			sessionFactory.getCurrentSession().delete(task);
		}
		
	}

}
