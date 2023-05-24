package com.rishabh.SpringDataJPAPOC.model.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Address {

    @Id
    @Column(name = "pin_code")
    private int pinCode;

    @Column(name = "street_number")
    private int streetNo;

    private String city;

    private String area;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
