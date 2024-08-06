package com.example.sbi_banking_app.controller;

import com.example.sbi_banking_app.dto.AccountsDto;
import com.example.sbi_banking_app.service.AccountService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
  private AccountService accountservice;

    public AccountsController(AccountService accountservice) {
        this.accountservice = accountservice;
    }
   //Open Bank Account or Add account Rest Api (/api/accounts)
   @PostMapping
    public ResponseEntity<AccountsDto> addAccount(@RequestBody AccountsDto accountsDto){
        return new ResponseEntity<>(accountservice.createAccount(accountsDto), HttpStatus.CREATED);
    }


    //Get Account Rest Api
    @GetMapping("/{id}")
    public ResponseEntity<AccountsDto> getAccountById(@PathVariable Long id){
        AccountsDto accountsDto = accountservice.getAccountById(id);
        return ResponseEntity.ok(accountsDto);
    }


    //Deposit Money in Sbi Bank
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountsDto>  deposit(
            @PathVariable Long id,
            @RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountsDto accountsDto = accountservice.deposit(id, amount);
        return ResponseEntity.ok(accountsDto);
    }


    //Withdraw Money in Sbi bank Api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountsDto> withdraw(
            @PathVariable Long id,
            @RequestBody  Map<String, Double> request) {

        Double amount = request.get("amount");
        AccountsDto accountsDto = accountservice.withdraw(id, amount);
        return ResponseEntity.ok(accountsDto);

    }


    //Get All accounts Rest Api
    @GetMapping
    public ResponseEntity<List<AccountsDto>> getAllAccounts(){
        List<AccountsDto> accountsDto = accountservice.getAllAccounts();
        return  ResponseEntity.ok(accountsDto);
    }

}

