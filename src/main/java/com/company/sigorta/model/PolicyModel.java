package com.company.sigorta.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "policy")
public class PolicyModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyId;
    private String policyNumber;
    private String policyType;
    private String startDate;
    private String endDate;
    private Double premiumAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @OneToMany(mappedBy = "policy")
    private Set<ClaimModel> claims;
}