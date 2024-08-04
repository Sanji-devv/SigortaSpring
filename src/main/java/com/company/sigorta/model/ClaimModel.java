package com.company.sigorta.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "claims")
public class ClaimModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private String claimNumber;
    private String claimDate;
    private Double claimAmount;
    private String claimStatus;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private PolicyModel policy;

    @OneToMany(mappedBy = "claim")
    private Set<PaymentModel> payments;
}
