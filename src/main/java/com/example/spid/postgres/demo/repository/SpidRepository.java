package com.example.spid.postgres.demo.repository;

import com.example.spid.postgres.demo.entities.Spid;
import com.example.spid.postgres.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SpidRepository extends CrudRepository<Spid, Long> {
    List<Spid> findSpidById(User user);
}