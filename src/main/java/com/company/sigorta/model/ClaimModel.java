package com.company.sigorta.model;
import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claim")
public class ClaimModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claimId;
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
