package com.example.onetoone.domain.multiDirectional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "multiPerson")
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "multiPerson")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private  String contact;

    @OneToOne
    @JoinColumn(name="Address_Id")
    private Address address;
}
