package com.ipaye.emanagementsystem.Model;


import jakarta.persistence.*;
import org.hibernate.Length;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(length=255)
    private String description;

    //Getters and setters

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }
}
