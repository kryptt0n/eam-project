package com.eam.fees_service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FeeRepository extends MongoRepository<Fee, String> {
    List<Fee> findByFeeType(boolean feeType);
    
    List<Fee> findByFeeAmtBetween(double minAmount, double maxAmount);
    
    List<Fee> findByFeeDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}