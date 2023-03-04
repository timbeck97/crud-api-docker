package com.crudcars.crud.repository;

import com.crudcars.crud.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
