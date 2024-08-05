package com.company.sigorta.model;
import jakarta.persistence.*;
import java.util.Set;

@Entity
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

    public Integer getClaimId() { return claimId; }

    public void setClaimId(Integer claimId) { this.claimId = claimId; }

    public String getClaimNumber() { return claimNumber; }

    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }

    public String getClaimDate() { return claimDate; }

    public void setClaimDate(String claimDate) { this.claimDate = claimDate; }

    public Double getClaimAmount() { return claimAmount; }

    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }

    public String getClaimStatus() { return claimStatus; }

    public void setClaimStatus(String claimStatus) { this.claimStatus = claimStatus; }

    public PolicyModel getPolicy() { return policy; }

    public void setPolicy(PolicyModel policy) { this.policy = policy; }

    public Set<PaymentModel> getPayments() { return payments; }

    public void setPayments(Set<PaymentModel> payments) { this.payments = payments; }
}
