package com.example.Postgres.RESTAPI.demo.service;


import com.example.Postgres.RESTAPI.demo.entities.Spid;
import com.example.Postgres.RESTAPI.demo.entities.Status;
import com.example.Postgres.RESTAPI.demo.entities.User;
import com.example.Postgres.RESTAPI.demo.repository.SpidRepository;
import com.example.Postgres.RESTAPI.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class SpidService {


    SpidRepository spidRepository;
    UserRepository userRepository;

    SpidService(SpidRepository spidRepository, UserRepository userRepository) {
        this.spidRepository = spidRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Spid> retriveAllSpids() {
        return spidRepository.findAll();
    }

    public Spid findSpidById(long id) throws Exception {
        Optional<Spid> spid = spidRepository.findById(id);

        if (!spid.isPresent()) {
            throw new Exception("This spid does not exists");
        }

        return spid.get();
    }

    @Transactional
    public Spid createSpid(Spid spid) throws Exception {
        Optional<Spid> currentSpid = spidRepository.findSpidByUserId(spid.getUserId());
        Optional<User> user = userRepository.findById(spid.getUserId().getId());

        if (!user.isPresent()) {
            throw new Exception("User does not exists");
        }


        if (currentSpid.isPresent()) {
            throw new Exception("User has already created a spid");
        }

        return spidRepository.save(spid);
    }

    public Spid changeStatus(long id) throws Exception {
        Spid spid = findSpidById(id);
        spid.setStatus(Status.READY_FOR_REVIEW);
        return spidRepository.save(spid);
    }

    @Transactional
    public void deleteSpid(long id) {
        spidRepository.deleteById(id);
    }

    public Object getAllSpids() {
        return getAllSpids();
    }

    public Object approveSpid() {
        return approveSpid();
    }
}