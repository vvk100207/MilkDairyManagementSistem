package ru.kostenko.MilkDairyManagementSistem.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="account")
public class MilkAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account")
    private int accountNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;





}
