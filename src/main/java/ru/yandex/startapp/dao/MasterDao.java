package ru.yandex.startapp.dao;

import ru.yandex.startapp.domain.Master;

import java.util.List;

public interface MasterDao {

	public void addMaster(Master master);

	public List<Master> listMaster();

	public Master getMasterById(Integer masterId);

	public void removeMaster(Integer id);

}
