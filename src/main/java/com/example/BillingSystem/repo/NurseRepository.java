package com.example.BillingSystem.repo;


import com.example.BillingSystem.model.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, Long> {
    // Custom queries can be added here, if needed
}
