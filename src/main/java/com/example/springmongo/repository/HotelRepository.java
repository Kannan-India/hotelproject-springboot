package com.example.springmongo.repository;

import com.example.springmongo.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//DAO - Data Access Object
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

    @Query(value = "{'pricePerNight':?0}")
    Hotel findByPricePerNight(int price);
}
