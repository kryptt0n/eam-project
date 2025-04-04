package com.eam.market_service;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market-order")
public class MarketOrderController {

    private final MarketOrderService marketOrderService;

    public MarketOrderController(MarketOrderService marketOrderService) {
        this.marketOrderService = marketOrderService;
    }

    @PostMapping
    public ResponseEntity<MarketOrder> create(@RequestBody MarketRequestDto marketOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(marketOrderService.createMarketOrder(marketOrder));
    }
}
