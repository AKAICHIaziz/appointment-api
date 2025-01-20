package com.azizdev.appointment_api.repository;

import com.azizdev.appointment_api.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
