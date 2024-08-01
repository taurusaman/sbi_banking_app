package com.example.sbi_banking_app.repository;
import com.example.sbi_banking_app.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Accounts, Long> {


}
