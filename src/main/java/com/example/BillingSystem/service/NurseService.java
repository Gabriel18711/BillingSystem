package com.example.BillingSystem.service;

import com.example.BillingSystem.model.Nurse;
import com.example.BillingSystem.repo.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    // Get all nurses
    public List<Nurse> getAllNurses() {
        return nurseRepository.findAll();
    }

    // Get nurse by ID
    public Optional<Nurse> getNurseById(Long id) {
        return nurseRepository.findById(id);
    }

    // Save or update nurse
    public Nurse saveNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    // Delete nurse by ID
    public void deleteNurse(Long id) {
        nurseRepository.deleteById(id);
    }
}
