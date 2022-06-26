package com.example.Postgres.RESTAPI.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Base {
    @Id
    private long id;
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;

}