package com.ecommerce.ecommerceapi.services;

import com.ecommerce.ecommerceapi.domain.Transaction;
import com.ecommerce.ecommerceapi.exceptions.EtBadRequestException;
import com.ecommerce.ecommerceapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface TransactionService {
    List<Transaction> fetchAllTransactions(Integer userId, Integer categoryId);

    Transaction fetchTransactionById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

    Transaction addTransaction(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;

    void updateTransaction(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException;

    void removeTransaction(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;
}
