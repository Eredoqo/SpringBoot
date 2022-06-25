package com.example.spid.postgres.demo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "spid")
public class Spid extends Base {

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
    private Status status;
    private Type type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Spid() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return id;
    }

    public User getId() {
        return user;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Spid(LocalDateTime createdAt, String createdBy, User user, long id, Status status, Type type) {
        super(createdAt, createdBy);
        this.id = id;
        this.status = status;
        this.type = type;
        this.user = user;
    }


}