package com.azizdev.appointment_api.service;

import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.mapper.DoctorMapper;
import com.azizdev.appointment_api.model.Doctor;
import com.azizdev.appointment_api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(DoctorMapper::toDoctorDTO) // Use the mapper to convert Doctor to DoctorDTO
                .collect(Collectors.toList());
    }

    public Optional<Doctor> getDoctorById(Integer id) {
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return doctor;
    }

}
