package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Datamodel;

public interface Dataservice{
	
	Datamodel save(Datamodel model);

    void deleteById(String id);

    Optional<Datamodel> findById(String id);

    List<Datamodel> findAll();
}
