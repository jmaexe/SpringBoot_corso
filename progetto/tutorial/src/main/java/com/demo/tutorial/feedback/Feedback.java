package com.demo.tutorial.feedback;

import com.demo.tutorial.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Person person;

    private String commento;

    public Feedback() {

    }

    public Feedback(Long id, Person person, String commento) {
        this.id = id;
        this.person = person;
        this.commento = commento;
    }

    public Feedback(Person person, String commento) {
        this.person = person;
        this.commento = commento;
    }

    public Long getUserId() {
        return this.person.getId();
    }

    public String getCommento() {
        return commento;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "user : " + person + "\ncommento : " + commento;
    }
}
