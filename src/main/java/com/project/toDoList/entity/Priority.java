package com.project.toDoList.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="priorities")
public class Priority {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="priority_id")
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany(
            mappedBy = "priority",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
