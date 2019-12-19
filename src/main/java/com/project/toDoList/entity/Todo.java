package com.project.toDoList.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="todos")
public class Todo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="todo_id")
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-dd-MM")
    @Column(name="due_date")
    private Date dueDate;
    private String note;
    @Column(name="checkf")
    private boolean checkf;
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "label_id")
    private Label label;

    @ManyToOne
    @JoinColumn(name="priority_id")
    private Priority priority;

    public boolean isCheck() {
        return checkf;
    }

    public void setCheck(boolean checkf) {
        this.checkf = checkf;
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


}
