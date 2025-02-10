package com.example.createdoctor.service;

import com.example.createdoctor.entity.Doctor;
import com.example.createdoctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}