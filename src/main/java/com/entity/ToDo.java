package com.entity;

import java.time.LocalDate;

public class ToDo {
	private String id;
	private String title;
	private String description;
	private LocalDate todoDate;
	private Boolean todoStatus;
	private User owner;

	public ToDo(String id,String title, String description, LocalDate todoDate, Boolean todoStatus, User owner) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.todoDate = todoDate;
		this.todoStatus = todoStatus;
		this.owner = owner;
	}
	public ToDo(String id,String title, LocalDate todoDate, Boolean todoStatus, User owner) {
		this.id = id;
		this.title = title;
		this.todoDate = todoDate;
		this.todoStatus = todoStatus;
		this.owner = owner;
	}
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getTodoDate() {
		return todoDate;
	}
	public void setTodoDate(LocalDate todoDate) {
		this.todoDate = todoDate;
	}
	public Boolean getTodoStatus() {
		return todoStatus;
	}
	public void setTodoStatus(Boolean todoStatus) {
		this.todoStatus = todoStatus;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
}
