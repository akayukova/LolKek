package ru.yandex.startapp.dao;

import java.util.List;
import ru.yandex.startapp.domain.Master;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class MasterDaoImpl implements MasterDao {	
	@Autowired
	private SessionFactory sessionFactory;
		
	public void addMaster(Master master) {
		Session tmpSession = sessionFactory.getCurrentSession();
		tmpSession.save(master);
	}

	@SuppressWarnings("unchecked")
	public List<Master> listMaster() {
		return sessionFactory.getCurrentSession().createQuery("from Master")
				.list();
	}

	@Override
	public void removeMaster(Integer id) {
		Master master = (Master) sessionFactory.getCurrentSession().load(
				Master.class, id);
		if (null != master) {
			sessionFactory.getCurrentSession().delete(master);
		}
		
	}

}
