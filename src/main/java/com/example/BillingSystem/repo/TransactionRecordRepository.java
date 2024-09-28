package com.example.BillingSystem.repo;


import com.example.BillingSystem.model.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRecordRepository extends JpaRepository<TransactionRecord, Long> {
}
