package com.koxx4.springbootrestdemo.entities;

import javax.persistence.*;

@Entity
@Table(name = "dog_medicine")
public class DogMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dose")
    private String dose;

    public DogMedicine() {
    }

    public DogMedicine(String name, String dose) {
        this.name = name;
        this.dose = dose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
