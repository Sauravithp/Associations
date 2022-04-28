package com.example.onetoone.domain.multiDirectional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "multiAddress")
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "multiAddress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String zipCode;

    @Column
    private String state;

    @Column
    private String street;

    @OneToOne(mappedBy = "address")
    private Person person;
}
