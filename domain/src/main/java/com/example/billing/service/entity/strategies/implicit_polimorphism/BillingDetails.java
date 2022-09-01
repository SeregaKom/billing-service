package com.example.billing.service.entity.strategies.implicit_polimorphism;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BD_TYPE")
public abstract class BillingDetails {
    @Id
    private Long id;
    @Column(nullable = false)
    protected String owner;
}
