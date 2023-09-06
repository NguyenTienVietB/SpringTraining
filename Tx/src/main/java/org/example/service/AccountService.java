package org.example.service;

import org.example.model.Account;
import org.example.exceptions.InsufficientBalanceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountService {

    private final Map<String, Account> accountStore = new HashMap<>();

    @Transactional
    public void deposit(String accountNumber, double amount) {
        Account account = getOrCreateAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
    }

    @Transactional
    public void withdraw(String accountNumber, double amount) {
        Account account = getOrCreateAccount(accountNumber);
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
    }

    public double getAccountBalance(String accountNumber) {
        Account account = accountStore.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return 0.0; // Return 0 for non-existing accounts
    }

    private Account getOrCreateAccount(String accountNumber) {
        return accountStore.computeIfAbsent(accountNumber, key -> new Account());
    }
}
