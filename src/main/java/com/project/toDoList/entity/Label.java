package com.project.toDoList.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="labels")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="label_id")
    private Long id;
    private String name;
    private String slug;

 /*   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="todo_id")
    private Todo todo;*/


}
