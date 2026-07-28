package com.etour.etour_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_master")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer custId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "cust_name")
    private String customerName;

    @Column(name = "contact_no")
    private String contactNo;

    private String address;

    @Column(name = "isactive")
    private Boolean isActive;
}