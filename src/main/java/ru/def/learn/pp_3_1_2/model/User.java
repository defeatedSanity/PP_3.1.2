package ru.def.learn.pp_3_1_2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "name should be from 2 to 20")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 20, message = "Name should be from 2 to 20")
    private String surname;

    @Column(name = "birthDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date should not be empty.")
    private Date birthDate;

    public User () {}

    public User(String name, String surname, Date birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthYear) {
        this.birthDate = birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s;",
                name, surname, new SimpleDateFormat("dd-MM-yyyy").format(birthDate));
    }
}
