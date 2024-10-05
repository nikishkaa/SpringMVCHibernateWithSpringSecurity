package com.websystique.springmvc.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OFFICES")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name = "name", unique = true, nullable = true)
    private String name;

    @NotEmpty
    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @NotEmpty
    @Column(name = "postal_code", unique = true, nullable = false)
    private String postalCode;
}
