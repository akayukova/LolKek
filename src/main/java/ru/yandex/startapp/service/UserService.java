package ru.yandex.startapp.service;

import java.util.List;

import ru.yandex.startapp.domain.User;

public interface UserService {

	public List<User> listUser();

	public User getUserByLogin(String login);

}
