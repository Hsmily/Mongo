package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Datamodel;

@Repository
public interface repo extends MongoRepository<Datamodel, String> {
    // Additional custom query methods can be defined here if needed
}
