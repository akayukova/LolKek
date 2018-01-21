package ru.yandex.startapp.dao;

import java.util.*;

import ru.yandex.startapp.domain.*;

public interface CaseDAO {

	public void addCase(Case case1);

	public void updateCase(Long caseId, Case case1);

	public Case getCaseById(Long caseId);

	public Collection<Case> getAllCases();

	public void deleteCase(Case case1);
}
