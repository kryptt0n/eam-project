package com.eam.fees_service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document
public class Fee {
    @Id
    private String feeId;
    private boolean feeType;
    private double feeAmt;
    private LocalDateTime feeDate;
    private LocalDateTime feeTime;
    private double fee_salestax;
    private String attribute;

    // Default constructor
    public Fee() {
    }

    // Constructor with all fields
    public Fee(boolean feeType, double feeAmt, LocalDateTime feeDate, 
              LocalDateTime feeTime, double fee_salestax, String attribute) {
        this.feeType = feeType;
        this.feeAmt = feeAmt;
        this.feeDate = feeDate;
        this.feeTime = feeTime;
        this.fee_salestax = fee_salestax;
        this.attribute = attribute;
    }

    // Getters and Setters
    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public boolean getFeeType() {
        return feeType;
    }

    public void setFeeType(boolean feeType) {
        this.feeType = feeType;
    }

    public double getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(double feeAmt) {
        this.feeAmt = feeAmt;
    }

    public LocalDateTime getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(LocalDateTime feeDate) {
        this.feeDate = feeDate;
    }

    public LocalDateTime getFeeTime() {
        return feeTime;
    }

    public void setFeeTime(LocalDateTime feeTime) {
        this.feeTime = feeTime;
    }

    public double getFee_salestax() {
        return fee_salestax;
    }

    public void setFee_salestax(double fee_salestax) {
        this.fee_salestax = fee_salestax;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    // Business methods from UML
    public void buyFees() {
        // Implementation for buying fees
        this.feeType = true;
        this.feeDate = LocalDateTime.now();
        this.feeTime = LocalDateTime.now();
    }

    public void sellFees() {
        // Implementation for selling fees
        this.feeType = false;
        this.feeDate = LocalDateTime.now();
        this.feeTime = LocalDateTime.now();
    }

    public double feesForOrder(double orderAmount) {
        // Sample implementation to calculate fees for an order
        // For example, a percentage of the order amount
        double feeAmount = orderAmount * 0.01; // 1% fee
        this.feeAmt = feeAmount;
        
        // Calculate sales tax on fee (example: 13% tax)
        this.fee_salestax = feeAmount * 0.13;
        
        return feeAmount + this.fee_salestax;
    }
}