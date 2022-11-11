package com.rishabh.SpringDataJPAPOC.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    private String code;
}
