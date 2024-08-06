package com.company.sigorta.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "policy")

public class PolicyModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyID;
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