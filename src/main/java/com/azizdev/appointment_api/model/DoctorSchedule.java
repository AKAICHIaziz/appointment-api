package com.azizdev.appointment_api.model;

import com.azizdev.appointment_api.enums.DayOfWeekEnum;
import jakarta.persistence.*;


@Entity
@Table(name="doctors_schedules")
public class DoctorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Enumerated(EnumType.STRING)
    private DayOfWeekEnum dayOfWeek;

    private String startTime;
    private String endTime;

}
