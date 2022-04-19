package com.example.billing.service.entity.onetoone.sharedprimarykey;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    public Long id;

    @NotNull
    public String street;

    @NotNull
    public String zipcode;

    @NotNull
    public String city;
}
