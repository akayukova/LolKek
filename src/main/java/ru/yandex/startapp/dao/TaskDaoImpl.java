package ru.yandex.startapp.dao;

import java.util.List;

import ru.yandex.startapp.domain.Master;
import ru.yandex.startapp.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTask(Task task) {
		Session tmpSession = sessionFactory.getCurrentSession();
		tmpSession.save(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> listTask() {
		return sessionFactory.getCurrentSession().createQuery("from Task").list();
	}

	@Override
	public void removeTask(Integer id) {
		Task task = (Task) sessionFactory.getCurrentSession().load(Task.class, id);
		if (null != task) {
			sessionFactory.getCurrentSession().delete(task);
		}

	}

	@Override
	public void editTask(Task task) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(task);
	}

	public Task getTaskById(Integer taskId) {
		// TODO Auto-generated method stub
		return (Task) sessionFactory.openSession().load(Task.class, taskId);

	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasksByMaster(Master master) {
		return (List<Task>) sessionFactory.getCurrentSession().createQuery(
				" select t" + " from ru.yandex.startapp.domain.Task as t left join t.master as m" + " where m.masterId = :masterId ")
				.setLong("masterId", master.getMasterId()).list();
	}

}
