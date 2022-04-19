package com.example.billing.service.entity.onetoone.sharedprimarykey;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    public Long id;

    public String username;

    @OneToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @PrimaryKeyJoinColumn
    public Address shippingAddress;

    public User() {
    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

}
