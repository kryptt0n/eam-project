package com.eam.market_service;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MarketOrder {
    @Id
    private String orderId;
    @Id
    private String transactionId;
    @Id
    private String feeId;
    private double bid;
    private double ask;
    private double previous;
    private double last;
    private String exchangeType;
    private String confirmationStatus;

    public MarketOrder() {
    }

    public MarketOrder(String orderId, String transactionId, String feeId, double bid, double ask, double previous, double last, String exchangeType, String confirmationStatus) {
        this.orderId = orderId;
        this.transactionId = transactionId;
        this.feeId = feeId;
        this.bid = bid;
        this.ask = ask;
        this.previous = previous;
        this.last = last;
        this.exchangeType = exchangeType;
        this.confirmationStatus = confirmationStatus;
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

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getPrevious() {
        return previous;
    }

    public void setPrevious(double previous) {
        this.previous = previous;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(String confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }
}
