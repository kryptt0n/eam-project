package com.eam.order_service.dto;

import java.time.LocalDateTime;

public class FeeDto {
    private String feeId;
    private boolean feeType;
    private double feeAmt;
    private LocalDateTime feeDate;
    private LocalDateTime feeTime;
    private double fee_salestax;
    private String attribute;

    // Default constructor
    public FeeDto() {
    }

    // Constructor with all fields
    public FeeDto(boolean feeType, double feeAmt, LocalDateTime feeDate,
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
}
