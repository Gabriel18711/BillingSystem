package com.example.BillingSystem.controller;

import com.example.BillingSystem.model.Nurse;
import com.example.BillingSystem.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nurses")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    // Get all nurses
    @GetMapping
    public ResponseEntity<List<Nurse>> getAllNurses() {
        List<Nurse> nurses = nurseService.getAllNurses();
        return new ResponseEntity<>(nurses, HttpStatus.OK);
    }

    // Get a nurse by ID
    @GetMapping("/{id}")
    public ResponseEntity<Nurse> getNurseById(@PathVariable("id") Long id) {
        Optional<Nurse> nurse = nurseService.getNurseById(id);
        return nurse.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new nurse
    @PostMapping
    public ResponseEntity<Nurse> createNurse(@RequestBody Nurse nurse) {
        Nurse savedNurse = nurseService.saveNurse(nurse);
        return new ResponseEntity<>(savedNurse, HttpStatus.CREATED);
    }

    // Update a nurse
    @PutMapping("/{id}")
    public ResponseEntity<Nurse> updateNurse(@PathVariable("id") Long id, @RequestBody Nurse nurseDetails) {
        Optional<Nurse> existingNurse = nurseService.getNurseById(id);

        if (existingNurse.isPresent()) {
            Nurse nurse = existingNurse.get();
            nurse.setName(nurseDetails.getName());
            nurse.setCompetenceLevel(nurseDetails.getCompetenceLevel());
            nurse.setHourlyRate(nurseDetails.getHourlyRate());

            Nurse updatedNurse = nurseService.saveNurse(nurse);
            return new ResponseEntity<>(updatedNurse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a nurse
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNurse(@PathVariable("id") Long id) {
        try {
            nurseService.deleteNurse(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
