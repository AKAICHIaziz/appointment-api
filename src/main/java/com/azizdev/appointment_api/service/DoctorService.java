package com.azizdev.appointment_api.service;

import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.exception.ResourceNotFoundException;
import com.azizdev.appointment_api.mapper.DoctorMapper;
import com.azizdev.appointment_api.model.Address;
import com.azizdev.appointment_api.model.Doctor;
import com.azizdev.appointment_api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public java.util.List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(DoctorMapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));
        return DoctorMapper.toDoctorDTO(doctor);
    }

    public void deleteDoctor(Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));
        doctorRepository.delete(doctor);
    }

    public Doctor createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return doctor;
    }

    public DoctorDTO  updateDoctor(Integer id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));

        doctor.setFirstname(doctorDTO.getFirstname());
        doctor.setLastname(doctorDTO.getLastname());
        doctor.setGender(doctorDTO.getGender());
        doctor.setAge(doctorDTO.getAge());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setTel(doctorDTO.getTel());

        if (doctorDTO.getAddress() != null) {
            doctor.setAddress(new Address(
                    doctorDTO.getAddress().getStreet(),
                    doctorDTO.getAddress().getCity(),
                    doctorDTO.getAddress().getState(),
                    doctorDTO.getAddress().getZipCode()
            ));
        }

        doctorRepository.save(doctor);
        return DoctorMapper.toDoctorDTO(doctor);
    }

}
