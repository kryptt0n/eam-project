package com.eam.market_service;


public class MarketRequestDto {
    private String orderId;
    private String transactionId;
    private String feeId;
    private double bid;
    private String exchangeType;

    public MarketRequestDto(String orderId, String transactionId, String feeId, double bid, String exchangeType) {
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.feeId = feeId;
        this.bid = bid;
        this.exchangeType = exchangeType;
    }

    public MarketRequestDto() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
}
