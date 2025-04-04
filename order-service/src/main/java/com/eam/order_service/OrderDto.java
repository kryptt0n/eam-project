package com.eam.order_service;

public class OrderDto {
    private String id;
    private Integer count;
    private String stock;
    private String account;
    private Action action;
    private String exchangeType;

    public OrderDto() {
    }

    public OrderDto(String id, Integer count, String stock, String account, Action action, String exchangeType) {
        this.id = id;
        this.count = count;
        this.stock = stock;
        this.account = account;
        this.action = action;
        this.exchangeType = exchangeType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }
}
