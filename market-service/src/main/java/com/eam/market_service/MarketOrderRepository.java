package com.eam.market_service;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketOrderRepository extends MongoRepository<MarketOrder, String> {
}
