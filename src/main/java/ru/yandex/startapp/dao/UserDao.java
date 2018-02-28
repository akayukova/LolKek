package ru.yandex.startapp.dao;

import java.util.List;
import ru.yandex.startapp.domain.User;

public interface UserDao {

	public List<User> listUser();

	public User getUserByLogin(String login);

}
