package com.example.createdoctor.service;

import com.example.createdoctor.entity.Doctor;
import com.example.createdoctor.entity.HashRequest;
import com.example.createdoctor.entity.HashResponse;
import com.example.createdoctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorService {
    private final String HASH_SERVICE_URL = "http://localhost:8080/hash";

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Doctor createDoctor(Doctor doctor) {
        try {
            HashRequest request = new HashRequest(doctor.getPasswordHash());
            HashResponse response = restTemplate.postForObject(HASH_SERVICE_URL, request, HashResponse.class);

            if (response != null) {
                doctor.setPasswordHash(response.getHash());
            }
        } catch (Exception e) {
            System.err.println("Hashing service unavailable. Saving raw password. please update the password");
        }

        return doctorRepository.save(doctor);
    }
}
