package ru.yandex.startapp.domain;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

	@Column(name = "timetable")
	private String timetable;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "master")	
	private Set<Task> tasks = new HashSet<Task>();
	
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

	public String getTimetable() {
		return timetable;
	}

	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}
	
}
