package com.crudcars.crud.controller;

import com.crudcars.crud.model.Car;
import com.crudcars.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @GetMapping
    public ResponseEntity<List<Car>> findAll(){
        return ResponseEntity.ok(carRepository.findAll());
    }
    @GetMapping(value = "/{}")
    public ResponseEntity findById(@PathVariable Long id){
        return carRepository.findById(id)
                .map(car-> ResponseEntity.ok(car))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        return ResponseEntity.status(201).body(carRepository.save(car));
    }


}
