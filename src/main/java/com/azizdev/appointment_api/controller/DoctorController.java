package com.azizdev.appointment_api.controller;

import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.model.Doctor;
import com.azizdev.appointment_api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor doctorToSave = new Doctor(
                doctor.getFirstname(),
                doctor.getLastname(),
                doctor.getGender(),
                doctor.getAge(),
                doctor.getSpecialization(),
                doctor.getYearsOfExperience(),
                doctor.getEmail(),
                doctor.getTel(),
                doctor.getAddress()
        );
        Doctor newDoctor = doctorService.createDoctor(doctorToSave);
        return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
    }



}
