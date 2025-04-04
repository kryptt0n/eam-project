package com.eam.market_service;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
public class MarketOrderService {
    
    public MarketOrder createMarketOrder(MarketRequestDto marketDto) {
        
        MarketOrder marketOrder = new MarketOrder();
        marketOrder.setOrderId(marketDto.getOrderId());
        marketOrder.setFeeId(marketDto.getFeeId());
        marketOrder.setTransactionId(marketOrder.getTransactionId());
        marketOrder.setBid(marketDto.getBid());
        marketOrder.setExchangeType(marketDto.getExchangeType());

        marketOrder.setAsk(Math.random() * 100);
        marketOrder.setLast(Math.random() * 100);
        marketOrder.setPrevious(Math.random() * 100);
        marketOrder.setConfirmationStatus("CONFIRMED");


        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("target/market_order.json");
        try {
            objectMapper.writeValue(file, marketOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Sent order to exchange market");

        return marketOrder;
    }
}
