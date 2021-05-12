package ru.kostenko.MilkDairyManagementSistem.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="milk")

public class MilkDairy {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "account")
   private int accountNumber;

   @Column(name = "name")
   private String name;

   @Column(name = "adress")
   private String address;

   @Column(name = "dairy")
   private int dairyNumber;

   @Column(name = "liter")
   private float liter;

   @Column(name = "price")
   private float priceLiter;

   @Column(name = "total")
   private float total;

   @Temporal(TemporalType.DATE)
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
   // обязательные обе аннотации для того чтобы выводить только дату календаря.
   @Column(name = "date")
   private Date date;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public int getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(int accountNumber) {
      this.accountNumber = accountNumber;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public int getDairyNumber() {
      return dairyNumber;
   }

   public void setDairyNumber(int dairyNumber) {
      this.dairyNumber = dairyNumber;
   }

   public float getLiter() {
      return liter;
   }

   public void setLiter(float liter) {
      this.liter = liter;
   }

   public float getPriceLiter() {
      return priceLiter;
   }

   public void setPriceLiter(float priceLiter) {
      this.priceLiter = priceLiter;
   }

   public float getTotal() {
      return total;
   }

   public void setTotal(float total) {
      this.total = total;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }
}


