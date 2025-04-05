package com.eam.fees_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fees")
public class FeeRestController {
    
    private final FeeService feeService;
    
    public FeeRestController(FeeService feeService) {
        this.feeService = feeService;
    }
    
    /**
     * Create a new fee
     */
    @PostMapping("/add")
    public ResponseEntity<Fee> addFee(@RequestBody FeeRequestDTO feeRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feeService.createFee(feeRequestDTO));
    }
    
    /**
     * Calculate fee for an order
     */
    @PostMapping("/calculate")
    public ResponseEntity<Fee> calculateFee(@RequestParam double orderAmount, @RequestParam boolean isBuyOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feeService.calculateFeeForOrder(orderAmount, isBuyOrder));
    }
}