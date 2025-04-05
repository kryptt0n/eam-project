package com.eam.fees_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FeeService {
    
    private final FeeRepository feeRepository;
    
    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }
    
    /**
     * Create a new fee from DTO
     */
    public Fee createFee(FeeRequestDTO feeRequestDTO) {
        Fee fee = new Fee();
        fee.setFeeType(feeRequestDTO.isFeeType());
        fee.setFeeAmt(feeRequestDTO.getFeeAmt());
        fee.setFee_salestax(feeRequestDTO.getFee_salestax());
        fee.setAttribute(feeRequestDTO.getAttribute());
        
        // Set current date and time
        fee.setFeeDate(LocalDateTime.now());
        fee.setFeeTime(LocalDateTime.now());
        
        // Save to database
        Fee savedFee = feeRepository.save(fee);
        
        // Use ObjectMapper to save to JSON file
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("target/fee.json");
        try {
            mapper.writeValue(file, fee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return savedFee;
    }
    
    /**
     * Calculate fee for an order
     */
    public Fee calculateFeeForOrder(double orderAmount, boolean isBuyOrder) {
        // Create a new fee
        Fee fee = new Fee();
        fee.setFeeType(isBuyOrder);
        fee.setFeeDate(LocalDateTime.now());
        fee.setFeeTime(LocalDateTime.now());
        
        // Calculate fee amount (for example, 1% of order amount)
        double feeAmount = orderAmount * 0.01;
        fee.setFeeAmt(feeAmount);
        
        // Calculate sales tax (for example, 13%)
        double salesTax = feeAmount * 0.13;
        fee.setFee_salestax(salesTax);
        
        // Set attribute
        fee.setAttribute(isBuyOrder ? "BUY_FEE" : "SELL_FEE");
        
        // Save to database
        Fee savedFee = feeRepository.save(fee);
        
        // Use ObjectMapper to save to JSON file - using the same file as createFee
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("target/fee.json");
        try {
            mapper.writeValue(file, fee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return savedFee;
    }
}