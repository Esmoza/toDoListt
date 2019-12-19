package com.project.toDoList.entity;

import javax.persistence.*;
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
    @OneToMany(
            mappedBy = "priority",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Todo> todos = new ArrayList<>();


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
