package com.azizdev.appointment_api.mapper;

import com.azizdev.appointment_api.dto.AddressDTO;
import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.model.Address;
import com.azizdev.appointment_api.model.Doctor;

public class DoctorMapper {

    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
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

    public static Doctor toDoctorEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();

        doctor.setId(doctorDTO.getId());
        doctor.setFirstname(doctorDTO.getFirstname());
        doctor.setLastname(doctorDTO.getLastname());
        doctor.setGender(doctorDTO.getGender());
        doctor.setAge(doctorDTO.getAge());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setYearsOfExperience(doctorDTO.getYearsOfExperience());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setTel(doctorDTO.getTel());

        if (doctorDTO.getAddress() != null) {
            Address address = new Address();
            address.setStreet(doctorDTO.getAddress().getStreet());
            address.setCity(doctorDTO.getAddress().getCity());
            address.setState(doctorDTO.getAddress().getState());
            address.setZipCode(doctorDTO.getAddress().getZipCode());
            doctor.setAddress(address);
        }

        return doctor;
    }
}
