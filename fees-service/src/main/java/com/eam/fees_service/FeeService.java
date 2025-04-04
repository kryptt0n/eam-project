package com.eam.fees_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeeService {
    
    private final FeeRepository feeRepository;
    
    @Autowired
    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }
    
    /**
     * Create a new fee
     */
    public Fee createFee(Fee fee) {
        return feeRepository.save(fee);
    }
    
    /**
     * Calculate and save fee for an order
     */
    public Fee calculateFeeForOrder(double orderAmount, boolean isBuyOrder) {
        Fee fee = new Fee();
        fee.setFeeType(isBuyOrder);
        fee.setFeeDate(LocalDateTime.now());
        fee.setFeeTime(LocalDateTime.now());
        
        double feeAmount = orderAmount * 0.01;
        fee.setFeeAmt(feeAmount);
        
        double salesTax = feeAmount * 0.13;
        fee.setFee_salestax(salesTax);
        
        fee.setAttribute(isBuyOrder ? "BUY_FEE" : "SELL_FEE");
        
        return feeRepository.save(fee);
    }
    
    /**
     * Get all fees
     */
    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }
    
    /**
     * Get fee by ID
     */
    public Optional<Fee> getFeeById(String id) {
        return feeRepository.findById(id);
    }
    
    /**
     * Get fees by type
     */
    public List<Fee> getFeesByType(boolean feeType) {
        return feeRepository.findByFeeType(feeType);
    }
    
    /**
     * Get fees by amount range
     */
    public List<Fee> getFeesByAmountRange(double minAmount, double maxAmount) {
        return feeRepository.findByFeeAmtBetween(minAmount, maxAmount);
    }
    
    /**
     * Get fees by date range
     */
    public List<Fee> getFeesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return feeRepository.findByFeeDateBetween(startDate, endDate);
    }
    
    /**
     * Update a fee
     */
    public Fee updateFee(String id, Fee feeDetails) {
        Optional<Fee> optionalFee = feeRepository.findById(id);
        if(optionalFee.isPresent()) {
            Fee existingFee = optionalFee.get();
            existingFee.setFeeType(feeDetails.getFeeType());
            existingFee.setFeeAmt(feeDetails.getFeeAmt());
            existingFee.setFeeDate(feeDetails.getFeeDate());
            existingFee.setFeeTime(feeDetails.getFeeTime());
            existingFee.setFee_salestax(feeDetails.getFee_salestax());
            existingFee.setAttribute(feeDetails.getAttribute());
            return feeRepository.save(existingFee);
        }
        return null;
    }
    
    /**
     * Delete a fee
     */
    public void deleteFee(String id) {
        feeRepository.deleteById(id);
    }
    
    /**
     * Process buy fees
     */
    public Fee processBuyFees(double orderAmount) {
        Fee fee = new Fee();
        fee.buyFees(); // Set fee type to buy and set current date/time
        fee.feesForOrder(orderAmount); // Calculate fees based on order amount
        return feeRepository.save(fee);
    }
    
    /**
     * Process sell fees
     */
    public Fee processSellFees(double orderAmount) {
        Fee fee = new Fee();
        fee.sellFees(); // Set fee type to sell and set current date/time
        fee.feesForOrder(orderAmount); // Calculate fees based on order amount
        return feeRepository.save(fee);
    }
}