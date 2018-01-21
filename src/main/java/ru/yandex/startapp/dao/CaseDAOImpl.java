package ru.yandex.startapp.dao;

import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.yandex.startapp.domain.Case;

@Repository
public class CaseDAOImpl implements CaseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCase(Case case1) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(case1);

	}

	// не понятно как работает

	public void updateCase(Long caseId, Case case1) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(case1);

	}

	public Case getCaseById(Long caseId) {
		// TODO Auto-generated method stub
		return (Case) sessionFactory.getCurrentSession().load(Case.class, caseId);
	}

	@SuppressWarnings("unchecked")
	public Collection<Case> getAllCases() {
		// TODO Auto-generated method stub
		return (List<Case>) sessionFactory.getCurrentSession().createCriteria(Case.class).list();

	}

	public void deleteCase(Case case1) {
		// TODO Auto-generated method stub
		case1 = (Case) sessionFactory.getCurrentSession().load(Case.class, case1.getCaseId());
		if (case1 != null) {
			sessionFactory.getCurrentSession().delete(case1);
		}

	}

}
