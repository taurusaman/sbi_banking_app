package com.example.sbi_banking_app.service;

import com.example.sbi_banking_app.dto.AccountsDto;
import com.example.sbi_banking_app.entity.Accounts;

import java.util.List;


public interface AccountService {

    AccountsDto createAccount(AccountsDto accountsDto);

    AccountsDto getAccountById(Long Id);

    AccountsDto deposit(Long id, double amount);

    AccountsDto withdraw(Long id, double amount);

    List<AccountsDto> getAllAccounts();

}
