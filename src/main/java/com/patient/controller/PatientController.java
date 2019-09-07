package com.patient.controller;

import com.patient.exception.ResourceNotFoundException;
import com.patient.model.Patient;
import com.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patient")
    public List<Patient> getPatients()
    {
        return this.patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable(name = "id") long id)
    {
        Patient patient = patientRepository.findById(id) .orElseThrow(
                () -> new ResourceNotFoundException("Patient" , "Id",id)
        );

        return patient;
    }

    @PostMapping("/patient")
    public Patient savePatient(@RequestBody Patient patient)
    {
        return patientRepository.save(patient);
    }

    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable(name = "id") long id , @RequestBody Patient patient)
    {
        Patient patient1 = patientRepository.findById(id) .orElseThrow(
                ()->new ResourceNotFoundException("Patient","Id",id)
        );

        patient1.setFullname(patient.getFullname());
        patient1.setNic(patient.getNic());
        patient1.setAddress(patient.getAddress());
        patient1.setAge(patient.getAge());
        patient1.setMobile(patient.getMobile());
        patient1.setDisease(patient.getDisease());
        patient1.setDocId(patient.getDocId());

        return patientRepository.save(patient1);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable(name = "id") long id)
    {
        Patient patient = patientRepository.findById(id) .orElseThrow(
                ()->new ResourceNotFoundException("Patient" , "Id",id)
        );
        patientRepository.delete(patient);
        return ResponseEntity.ok().build();
    }
}

