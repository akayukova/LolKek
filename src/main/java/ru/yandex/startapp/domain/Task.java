package ru.yandex.startapp.domain;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "tasks")
public class Task {

	@Id
	@Column(name = "task_id")
	@GeneratedValue
	private Integer taskId;

	@Column(name = "master_id")
	private Integer masterId;

	@Column(name = "case_id")
	private Integer caseId;

	@NotNull
	@Column(name = "room")
	private String room;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "master_id", insertable = false, updatable = false)
	private Master master;

	@NotNull
	@Column(name = "description")
	private String description;

	@Column(name = "priority")
	private int priority;

	@Column(name = "status")
	private boolean status;

	@NotNull
	@Column(name = "building")
	private String building;

	@Column(name = "time", nullable = false, columnDefinition = "DATETIME default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setTaskId(Integer taskIdS) {
		taskId = taskIdS;
	}

	public void setMasterId(Integer masterIdS) {
		masterId = masterIdS;
	}

	public void setCaseId(Integer caseIdS) {
		caseId = caseIdS;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "Task{" + "id=" + taskId + ", room=" + "" + ", name=" + "" + '}';
	}

	public Task() {

	}

}
