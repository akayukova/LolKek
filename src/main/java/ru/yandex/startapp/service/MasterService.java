package ru.yandex.startapp.service;

import java.util.List;

import ru.yandex.startapp.domain.Master;

public interface MasterService {
	
	
	public void addMaster(Master master);

	/*public List<Master> listMaster();
*/
	public void removeMaster(Integer id);
	

}
