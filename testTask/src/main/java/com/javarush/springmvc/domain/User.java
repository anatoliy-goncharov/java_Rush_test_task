package com.javarush.springmvc.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Anatoliy_Goncharov on 21.08.2014.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false, length = 8)
    @GeneratedValue
    private Integer id; //Идентификатор БД

    @Column(name = "name", nullable = false, length = 25)
    private String name; //Имя пользователя

    @Column(name = "age", nullable = true)
    private Integer age; // Возраст пользователя

    @Column(name = "isAdmin", columnDefinition = "BIT")
    private Boolean isAdmin; // является ли админом

    @Column (name = "createdDate", nullable = true)
    private Timestamp createdDate; // Дата создания пользователя

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
            this.createdDate = createdDate;
    }
}
