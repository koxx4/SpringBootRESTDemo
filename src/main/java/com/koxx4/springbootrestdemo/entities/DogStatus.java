package com.koxx4.springbootrestdemo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dog_status")
public class DogStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "status_message")
    private String message;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "date")
    private LocalDate date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "time")
    private LocalTime time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "status_id")
    List<DogMedicine> medicines;

    public DogStatus() {
    }

    public DogStatus(String message, LocalDate date, LocalTime time, List<DogMedicine> medicines) {
        this.message = message;
        this.date = date;
        this.time = time;
        this.medicines = medicines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DogMedicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<DogMedicine> medicines) {
        this.medicines = medicines;
    }

    public void addMedicine(DogMedicine medicine){
        if(this.medicines == null)
            medicines = new ArrayList<>();

        medicines.add(medicine);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
