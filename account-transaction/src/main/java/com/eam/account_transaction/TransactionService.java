package com.eam.account_transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setOrderId(transactionRequestDTO.getOrderId());
        transaction.setTransactionType(transactionRequestDTO.getTransactionType());
        transaction.setTransactionPrice(transactionRequestDTO.getTransactionPrice());
        transaction.setTickerSymbol(transactionRequestDTO.getTickerSymbol());
        transaction.setOrderDateTime(LocalDateTime.now());
        transaction.setOrderAmount(transactionRequestDTO.getOrderAmount());

        transactionRepository.save(transaction);

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("target/transaction.json");
        try {
            mapper.writeValue(file, transaction);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return transaction;
    }
}
