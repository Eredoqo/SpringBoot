package com.example.spid.postgres.demo.entities;

import java.time.LocalDateTime;

public class Base {
    private LocalDateTime createdAt;
    private String createdBy;

    public Base(LocalDateTime createdAt, String createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Base() {

    }
}