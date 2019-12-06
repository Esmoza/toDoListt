package com.project.toDoList.dto;

import java.util.Date;
import java.util.List;


public class TodoDto {
    private Long id;
    private String title;
    private Date dueDate;
    private Long priority;
    private String note;

    public List<PriorityDto> getPriorityDtoList() {
        return priorityDtoList;
    }

    public void setPriorityDtoList(List<PriorityDto> priorityDtoList) {
        this.priorityDtoList = priorityDtoList;
    }

    private List<PriorityDto> priorityDtoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
