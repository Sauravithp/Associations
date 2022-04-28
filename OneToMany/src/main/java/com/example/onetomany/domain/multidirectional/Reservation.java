package com.example.onetomany.domain.multidirectional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "MultiReservation")
@Table(name = "MultiReservation")
@Getter
@Setter
@RequiredArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

}
