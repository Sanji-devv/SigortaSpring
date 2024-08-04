package com.company.sigorta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class PaymentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private String paymentDate;
    private Double paymentAmount;
    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private ClaimModel claim;
}

