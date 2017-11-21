package ru.yandex.startapp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
	
	
	@Id
	@Column(name = "task_id")
	@GeneratedValue
	private Long taskId;

	@Column(name = "master_id")
	private Long masterId;

	@Column(name = "case_id")
	private Long caseId;

/*	@Column(name = "case_text")
	private String caseText;

	@Column(name = "case_status")
	private String caseStatus;

	@Column(name = "case_execute_before")
	private String caseExecuteBefore;

	@Column(name = "room_number")
	private String roomNumber;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_first_name")
	private String userFirstName;

	@Column(name = "user_last_name")
	private String userLastName;*/

	// Getters

	public Long getTaskId() {
		return taskId;
	}

	public Long getMasterId() {
		return masterId;
	}

	public Long getCaseId() {
		return caseId;
	}

	/*public String getCaseText() {
		return caseText;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public String getCaseExecuteBefore() {
		return caseExecuteBefore;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}*/

	// --- Setters

	public void setTaskId(Long taskIdS) {
		taskId = taskIdS;
	}

	public void setMasterId(Long masterIdS) {
		masterId = masterIdS;
	}

	public void setCaseId(Long caseIdS) {
		caseId = caseIdS;
	}

	/*public void setCaseText(String caseTextS) {
		caseText = caseTextS;
	}

	public void setCaseStatus(String caseStatusS) {
		caseStatus = caseStatusS;
	}

	public void setCaseExecuteBefore(String caseExecuteBeforeS) {
		caseExecuteBefore = caseExecuteBeforeS;
	}

	public void setRoomNumber(String roomNumberS) {
		roomNumber = roomNumberS;
	}

	public void setUserEmail(String userEmailS) {
		userEmail = userEmailS;
	}

	public void setUserFirstName(String userFirstNameS) {
		userFirstName = userFirstNameS;
	}

	public void setUserLastName(String userLastNameS) {
		userLastName = userLastNameS;
	}
*/
	@Override
	public String toString() {
		return "Task{" + "id=" + taskId + ", room=" + "" + ", name=" + "" + '}';
	}
	
public Task() {
		
	}
	

}
