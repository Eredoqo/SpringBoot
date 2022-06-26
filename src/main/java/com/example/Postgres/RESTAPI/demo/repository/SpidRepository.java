package com.example.Postgres.RESTAPI.demo.repository;

import com.example.Postgres.RESTAPI.demo.entities.Spid;
import com.example.Postgres.RESTAPI.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface SpidRepository extends CrudRepository<Spid, Long> {
    Optional<Spid> findSpidByUserId(User user);

}