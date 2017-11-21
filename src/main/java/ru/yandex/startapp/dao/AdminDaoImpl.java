package ru.yandex.startapp.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.yandex.startapp.domain.Admin;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public boolean verifyAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

}
