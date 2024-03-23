package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Datamodel;
import com.example.demo.service.Dataservice;


@RestController
@RequestMapping("/model")
public class controller {

	  @Autowired
	    private Dataservice service;
	  
    @PostMapping("/addmodel")
    public ResponseEntity<Datamodel> createModel(@RequestBody Datamodel model) {
    	Datamodel savedmodel = service.save(model);
        return new ResponseEntity<>(savedmodel, HttpStatus.CREATED);
    }

    @PutMapping("/getmodel/{id}")
    public ResponseEntity<Datamodel> updateModel(@PathVariable String id, @RequestBody Datamodel model) {
        model.setId(id); // Ensure the provided ID matches the model object
        Datamodel updatedModel = service.save(model);
        return new ResponseEntity<>(updatedModel, HttpStatus.OK);
    }
    @DeleteMapping("/getmodel/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getmodel/{id}")
    public ResponseEntity<Datamodel> getModelById(@PathVariable String id) {
    	Datamodel model = service.findById(id).orElse(null);
        if (model != null) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Datamodel>> getAllModels() {
        List<Datamodel> models = service.findAll();
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
