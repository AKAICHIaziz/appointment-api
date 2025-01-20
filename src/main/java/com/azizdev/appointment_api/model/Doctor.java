package com.azizdev.appointment_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private String specialization;
    private Integer yearsOfExperience;
    private String email;
    private String tel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<DoctorSchedule> doctorSchedules;

    public Doctor(String firstname, String lastname, String gender, Integer age, String specialization, Integer yearsOfExperience, String email, String tel, Address address, List<DoctorSchedule> doctorSchedules) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.doctorSchedules = doctorSchedules;
    }

    public Doctor() {
    }

}
