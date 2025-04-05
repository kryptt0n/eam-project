package com.eam.fees_service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends MongoRepository<Fee, String> {
}