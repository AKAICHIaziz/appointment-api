package com.azizdev.appointment_api.mapper;

import com.azizdev.appointment_api.dto.AddressDTO;
import com.azizdev.appointment_api.dto.DoctorDTO;
import com.azizdev.appointment_api.dto.DoctorScheduleDTO;
import com.azizdev.appointment_api.enums.DayOfWeekEnum;
import com.azizdev.appointment_api.model.Address;
import com.azizdev.appointment_api.model.Doctor;
import com.azizdev.appointment_api.model.DoctorSchedule;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorMapper {

    // Converts Doctor entity to DoctorDTO
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

        // Mapping Address
        if (doctor.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(doctor.getAddress().getStreet());
            addressDTO.setCity(doctor.getAddress().getCity());
            addressDTO.setState(doctor.getAddress().getState());
            addressDTO.setZipCode(doctor.getAddress().getZipCode());
            dto.setAddress(addressDTO);
        }

        // Mapping DoctorSchedule
        List<DoctorScheduleDTO> scheduleDTOs = doctor.getDoctorSchedules().stream()
                .map(schedule -> new DoctorScheduleDTO(
                        schedule.getDayOfWeek().name(),
                        schedule.getStartTime(),
                        schedule.getEndTime()
                ))
                .collect(Collectors.toList());

        dto.setDoctorSchedules(scheduleDTOs);

        return dto;
    }

    // Converts DoctorDTO to Doctor entity, including setting up DoctorSchedules with their Doctor entity
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

        // Mapping Address
        if (doctorDTO.getAddress() != null) {
            Address address = new Address();
            address.setStreet(doctorDTO.getAddress().getStreet());
            address.setCity(doctorDTO.getAddress().getCity());
            address.setState(doctorDTO.getAddress().getState());
            address.setZipCode(doctorDTO.getAddress().getZipCode());
            doctor.setAddress(address);
        }

        // Mapping DoctorSchedules
        List<DoctorSchedule> doctorSchedules = doctorDTO.getDoctorSchedules().stream()
                .map(scheduleDTO -> {
                    DoctorSchedule schedule = new DoctorSchedule();
                    schedule.setDayOfWeek(DayOfWeekEnum.valueOf(scheduleDTO.getDayOfWeek())); // Convert String to Enum
                    schedule.setStartTime(scheduleDTO.getStartTime());
                    schedule.setEndTime(scheduleDTO.getEndTime());
                    // Ensure the schedule knows the Doctor
                    schedule.setDoctor(doctor); // Set the doctor for the schedule
                    return schedule;
                })
                .collect(Collectors.toList());

        doctor.setDoctorSchedules(doctorSchedules);

        return doctor;
    }
}
