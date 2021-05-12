package ru.kostenko.MilkDairyManagementSistem.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="price")
@Data
public class MilkPrice {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="current_price")
    private float current_price;

    @Column(name="new_price")
    private float new_price;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)   // обязательные обе аннотации для того чтобы выводить только дату календаря.
    @Column(name= "date")
    private Date date;
}
