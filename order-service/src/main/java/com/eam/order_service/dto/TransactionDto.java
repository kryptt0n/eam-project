package com.eam.order_service.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private String id;
    private String orderId;
    private String transactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private LocalDateTime orderDateTime;
    private double orderAmount;
    private double balanceAmount;

    public TransactionDto() {
    }

    public TransactionDto(String id, String orderId, String transactionType, String tickerSymbol, double transactionPrice, LocalDateTime orderDateTime, double orderAmount, double balanceAmount) {
        this.id = id;
        this.orderId = orderId;
        this.transactionType = transactionType;
        this.tickerSymbol = tickerSymbol;
        this.transactionPrice = transactionPrice;
        this.orderDateTime = orderDateTime;
        this.orderAmount = orderAmount;
        this.balanceAmount = balanceAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
