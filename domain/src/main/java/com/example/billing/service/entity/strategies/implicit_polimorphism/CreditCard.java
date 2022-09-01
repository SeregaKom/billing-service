package com.example.billing.service.entity.strategies.implicit_polimorphism;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AttributeOverride(
        name = "owner",
        column = @Column(name = "CC_OWNER", nullable = false))
public class CreditCard extends BillingDetails{
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String cardNumber;
}
