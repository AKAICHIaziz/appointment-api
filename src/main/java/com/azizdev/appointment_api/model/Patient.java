package com.azizdev.appointment_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private String age;
    private String tel;
    private String email;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
