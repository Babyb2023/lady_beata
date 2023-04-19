package com.beata.beataCRUD.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderTracking_Info")
public class OrderTrackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "order_status")
    String orderStatus;
    @Column(name = "orderNo")
    int orderNo;
    @Column(name = "orderSummary")
    String orderSummary;
    @Column(name = "email")
    String email;
    @Column(name = "deliveryDate")
    String deliveryDate;
    @Column(name = "customerSupport")
    String customerSupport;
}
