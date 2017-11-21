package ru.yandex.startapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "masters")
public class Master {
	
	@Id
	@Column(name = "master_id")
    @GeneratedValue
	private Integer masterId;
	
	@Column(name = "name")
	private String name;
	

	@Column(name = "specialization")
	private String spec;

	/*@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;*/
	
	@Column(name = "timetable")
	private Integer timetable;
	
	//Getters	
	@Override
	public String toString() {
		return "Master{" + "id=" + masterId + ", Name=" + name + ", Specialization=" + spec + '}';
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getTimetable() {
		return timetable;
	}

	public void setTimetable(Integer timetable) {
		this.timetable = timetable;
	}
	
}
