package com.eam.fees_service;


//This class represents an Order object for reference in the Fee Service
//It matches the Order structure from your Order Service
public class Order {
 private String id;
 private Integer count;
 private String stock;
 private String account;
 private Action action;

 public Order() {
 }

 public Order(String id, Integer count, String stock, String account, Action action) {
     this.id = id;
     this.count = count;
     this.stock = stock;
     this.account = account;
     this.action = action;
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
}