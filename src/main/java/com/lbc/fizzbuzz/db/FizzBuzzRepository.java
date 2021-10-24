package com.lbc.fizzbuzz.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lbc.fizzbuzz.model.FizzBuzzDTO;

@Repository
public interface FizzBuzzRepository extends MongoRepository<FizzBuzzDTO, String> {
}
