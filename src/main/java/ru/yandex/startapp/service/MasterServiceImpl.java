package ru.yandex.startapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import ru.yandex.startapp.domain.Master;
import ru.yandex.startapp.dao.*;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private MasterDao masterDao;

	@Transactional
	public void addMaster(Master master) {
		System.out.println("in maserDAO");
		masterDao.addMaster(master);
	}

	@Transactional
	public List<Master> listMaster() {
		return masterDao.listMaster();
	}

	@Transactional
	public void removeMaster(Integer id) {
		masterDao.removeMaster(id);

	}

	@Transactional
	public Master getMasterById(Integer id) {
		return masterDao.getMasterById(id);
	}

}
