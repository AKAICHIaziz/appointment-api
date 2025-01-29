package com.azizdev.appointment_api.controller;

import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.mapper.DoctorMapper;
import com.azizdev.appointment_api.model.Doctor;
import com.azizdev.appointment_api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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


    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Integer id) {
        Optional<Doctor> optionalDoctor = doctorService.getDoctorById(id);
        if(optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            DoctorDTO doctorDTO = DoctorMapper.toDoctorDTO(doctor);
            return new ResponseEntity<>(doctorDTO, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        Doctor doctor = DoctorMapper.toDoctorEntity(doctorDTO);
        doctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(DoctorMapper.toDoctorDTO(doctor), HttpStatus.CREATED);
    }



}
