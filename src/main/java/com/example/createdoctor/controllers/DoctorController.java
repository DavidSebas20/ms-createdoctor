package com.example.createdoctor.controllers;

import com.example.createdoctor.entity.Doctor;
import com.example.createdoctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> createPatient(@RequestBody Doctor doctor) {
        Doctor savedPatient = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }
}
