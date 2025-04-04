package com.eam.fees_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fees")
public class FeeController {
    
    private final FeeService feeService;
    private final RestTemplate restTemplate;
    
    @Autowired
    public FeeController(FeeService feeService, RestTemplate restTemplate) {
        this.feeService = feeService;
        this.restTemplate = restTemplate;
    }
    
    /**
     * Create a new fee
     */
    @PostMapping
    public ResponseEntity<Fee> createFee(@RequestBody Fee fee) {
        Fee createdFee = feeService.createFee(fee);
        return new ResponseEntity<>(createdFee, HttpStatus.CREATED);
    }
    
    /**
     * Calculate fee for an order
     */
    @PostMapping("/calculate")
    public ResponseEntity<Fee> calculateFee(
            @RequestParam double orderAmount,
            @RequestParam boolean isBuyOrder) {
        Fee calculatedFee = feeService.calculateFeeForOrder(orderAmount, isBuyOrder);
        return new ResponseEntity<>(calculatedFee, HttpStatus.CREATED);
    }
    
    /**
     * Get all fees
     */
    @GetMapping
    public ResponseEntity<List<Fee>> getAllFees() {
        List<Fee> fees = feeService.getAllFees();
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }
    
    /**
     * Get fee by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(@PathVariable String id) {
        Optional<Fee> fee = feeService.getFeeById(id);
        return fee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    /**
     * Get fees by type
     */
    @GetMapping("/type/{feeType}")
    public ResponseEntity<List<Fee>> getFeesByType(@PathVariable boolean feeType) {
        List<Fee> fees = feeService.getFeesByType(feeType);
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }
    
    /**
     * Get fees by amount range
     */
    @GetMapping("/amount-range")
    public ResponseEntity<List<Fee>> getFeesByAmountRange(
            @RequestParam double minAmount,
            @RequestParam double maxAmount) {
        List<Fee> fees = feeService.getFeesByAmountRange(minAmount, maxAmount);
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }
    
    /**
     * Get fees by date range
     */
    @GetMapping("/date-range")
    public ResponseEntity<List<Fee>> getFeesByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        List<Fee> fees = feeService.getFeesByDateRange(startDate, endDate);
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }
    
    /**
     * Update a fee
     */
    @PutMapping("/{id}")
    public ResponseEntity<Fee> updateFee(
            @PathVariable String id,
            @RequestBody Fee feeDetails) {
        Fee updatedFee = feeService.updateFee(id, feeDetails);
        if (updatedFee != null) {
            return new ResponseEntity<>(updatedFee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    /**
     * Delete a fee
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFee(@PathVariable String id) {
        feeService.deleteFee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Process buy fees for an order
     */
    @PostMapping("/buy")
    public ResponseEntity<Fee> processBuyFees(@RequestParam double orderAmount) {
        Fee fee = feeService.processBuyFees(orderAmount);
        return new ResponseEntity<>(fee, HttpStatus.CREATED);
    }
    
    /**
     * Process sell fees for an order
     */
    @PostMapping("/sell")
    public ResponseEntity<Fee> processSellFees(@RequestParam double orderAmount) {
        Fee fee = feeService.processSellFees(orderAmount);
        return new ResponseEntity<>(fee, HttpStatus.CREATED);
    }
    
    /**
     * Process fees for an order from Order Service
     */
    @PostMapping("/order/{orderId}")
    public ResponseEntity<Fee> processFeesForOrder(@PathVariable String orderId) {
        // Get order details from Order Service using RestTemplate
        String orderServiceUrl = "http://order-service/api/orders/" + orderId;
        ResponseEntity<Order> response = restTemplate.getForEntity(orderServiceUrl, Order.class);
        
        if (response.getStatusCode() == HttpStatus.OK) {
            Order order = response.getBody();
            if (order != null) {
                // Determine if it's a buy or sell order
                boolean isBuyOrder = order.getAction() == Action.BUY;
                
                // Calculate fee based on order amount (assuming count * some price)
                double orderAmount = order.getCount() * 100; // Example calculation
                
                Fee fee = feeService.calculateFeeForOrder(orderAmount, isBuyOrder);
                return new ResponseEntity<>(fee, HttpStatus.CREATED);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}