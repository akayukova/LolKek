package ru.yandex.startapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.yandex.startapp.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUserByLogin(String login) {
		return (User) sessionFactory.openSession().createQuery("FROM User U WHERE U.login = :login")
				.setString("login", login).uniqueResult();
	}

}
