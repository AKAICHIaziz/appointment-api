package com.azizdev.appointment_api.mapper;

import com.azizdev.appointment_api.dto.AddressDTO;
import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.model.Doctor;

public class DoctorMapper {

    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setFirstname(doctor.getFirstname());
        dto.setLastname(doctor.getLastname());
        dto.setGender(doctor.getGender());
        dto.setAge(doctor.getAge());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setYearsOfExperience(doctor.getYearsOfExperience());
        dto.setEmail(doctor.getEmail());
        dto.setTel(doctor.getTel());

        if (doctor.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(doctor.getAddress().getStreet());
            addressDTO.setCity(doctor.getAddress().getCity());
            addressDTO.setState(doctor.getAddress().getState());
            addressDTO.setZipCode(doctor.getAddress().getZipCode());
            dto.setAddress(addressDTO);
        }

        return dto;
    }
}