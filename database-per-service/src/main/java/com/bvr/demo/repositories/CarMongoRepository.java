package com.bvr.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bvr.demo.models.Car;

public interface CarMongoRepository extends CrudRepository<Car, String> {

}
