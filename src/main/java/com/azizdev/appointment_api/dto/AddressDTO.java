package com.azizdev.appointment_api.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AddressDTO {

    private String street;
    private String city;
    private String state;
    private String zipCode;

    public AddressDTO() {}

}