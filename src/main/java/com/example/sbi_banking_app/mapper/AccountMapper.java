package com.example.sbi_banking_app.mapper;

import com.example.sbi_banking_app.dto.AccountsDto;
import com.example.sbi_banking_app.entity.Accounts;

public class AccountMapper {

    //map to java object
    public static Accounts mapToAccount(AccountsDto accountsDto){
        return new Accounts(
                 accountsDto.getId(),
                     accountsDto.getAccountHolderName(),
                     accountsDto.getBalance()
             );
    }

    //java object to map
    public static AccountsDto mapToAccountDto(Accounts accounts){

        return new AccountsDto(
                 accounts.getId(),
                 accounts.getAccountHolderName(),
                 accounts.getBalance()
         );
    }
}
