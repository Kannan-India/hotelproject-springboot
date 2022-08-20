package com.example.springmongo.repository;

import com.example.springmongo.model.MReference;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MReferenceRepository extends MongoRepository<MReference, String> {
}
