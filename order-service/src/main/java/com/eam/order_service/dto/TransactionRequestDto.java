package com.eam.order_service.dto;

public class TransactionRequestDto {
    private String orderId;
    private String transactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private double orderAmount;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(String orderId, String transactionType, String tickerSymbol, double transactionPrice, double orderAmount) {
        this.orderId = orderId;
        this.transactionType = transactionType;
        this.tickerSymbol = tickerSymbol;
        this.transactionPrice = transactionPrice;
        this.orderAmount = orderAmount;
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


    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
