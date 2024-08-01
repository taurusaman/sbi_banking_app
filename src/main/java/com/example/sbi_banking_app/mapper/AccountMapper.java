package com.example.sbi_banking_app.mapper;

import com.example.sbi_banking_app.dto.AccountsDto;
import com.example.sbi_banking_app.entity.Accounts;

public class AccountMapper {

    //map to java object
    public static Accounts mapToAccount(AccountsDto accountsDto){
             Accounts accounts = new Accounts(
                 accountsDto.getId(),
                     accountsDto.getAccountHolderName(),
                     accountsDto.getBalance()
             );
             return  accounts;
    }

    //map to java object
    public static AccountsDto mapToAccountDto(Accounts accounts){
         AccountsDto accountsDto = new AccountsDto(
                 accounts.getId(),
                 accounts.getAccountHolderName(),
                 accounts.getBalance()
         );

         return accountsDto;
    }
}
