package com.example.sbi_banking_app.service.impl;
import com.example.sbi_banking_app.dto.AccountsDto;
import com.example.sbi_banking_app.entity.Accounts;
import com.example.sbi_banking_app.mapper.AccountMapper;
import com.example.sbi_banking_app.repository.AccountRepository;
import com.example.sbi_banking_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountsDto createAccount(AccountsDto accountsDto) {

        Accounts accounts = AccountMapper.mapToAccount(accountsDto);
        Accounts savedAccount =  accountRepository.save(accounts);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountsDto getAccountById(Long id) {

        Accounts accounts = accountRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Account doesn't Exist"));
        return AccountMapper.mapToAccountDto(accounts);
    }

    @Override
    public AccountsDto deposit(Long id, double amount) {

        Accounts accounts = accountRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Account does not exist"));

        double total = accounts.getBalance() + amount;
        accounts.setBalance(total);
        Accounts savedAccount = accountRepository.save(accounts);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountsDto withdraw(Long id, double amount) {

        Accounts accounts = accountRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Account does not exist"));

        if(accounts.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }

        double total = accounts.getBalance() - amount;
        accounts.setBalance(total);
        Accounts savedAccount = accountRepository.save(accounts);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountsDto> getAllAccounts() {

        List<Accounts> accountsList = accountRepository.findAll();
        return accountsList.stream().map((accounts1)->
                AccountMapper.mapToAccountDto(accounts1)).collect(Collectors.toList());

    }

}
