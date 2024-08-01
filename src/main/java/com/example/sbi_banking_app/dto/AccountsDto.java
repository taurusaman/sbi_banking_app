package com.example.sbi_banking_app.dto;
import lombok.Data;

@Data

public class AccountsDto {

   private Long id;
   private String accountHolderName;
   private double balance;

   public AccountsDto(Long id, String accountHolderName, double balance) {
      this.id = id;
      this.accountHolderName = accountHolderName;
      this.balance = balance;
   }

   public Long getId() {
      return id;
   }

   public String getAccountHolderName() {
      return accountHolderName;
   }

   public double getBalance() {
      return balance;
   }
}
