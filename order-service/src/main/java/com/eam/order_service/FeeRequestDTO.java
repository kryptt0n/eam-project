package com.eam.order_service;

public class FeeRequestDTO {
    private boolean feeType;
    private double feeAmt;
    private double fee_salestax;
    private String attribute;

    public FeeRequestDTO() {
    }

    public FeeRequestDTO(boolean feeType, double feeAmt, double fee_salestax, String attribute) {
        this.feeType = feeType;
        this.feeAmt = feeAmt;
        this.fee_salestax = fee_salestax;
        this.attribute = attribute;
    }

    public boolean isFeeType() {
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