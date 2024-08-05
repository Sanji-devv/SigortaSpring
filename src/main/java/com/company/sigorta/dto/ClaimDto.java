package com.company.sigorta.dto;
import java.time.LocalDateTime;
import java.util.Set;

public class ClaimDto
{
    private Integer claimId;
    private String claimNumber;
    private LocalDateTime claimDate;
    private Double claimAmount;
    private String claimStatus;

    private PolicyDto policy; // İlişkili Policy
    private Set<PaymentDto> payments; // İlişkili Payments

    public ClaimDto() {}

    public ClaimDto(Integer claimId, String claimNumber, LocalDateTime claimDate, Double claimAmount, String claimStatus, PolicyDto policy, Set<PaymentDto> payments)
    {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.claimDate = claimDate;
        this.claimAmount = claimAmount;
        this.claimStatus = claimStatus;
        this.policy = policy;
        this.payments = payments;
    }

    public Integer getClaimId() { return claimId; }

    public void setClaimId(Integer claimId) { this.claimId = claimId; }

    public String getClaimNumber() { return claimNumber; }

    public void setClaimNumber(String claimNumber) { this.claimNumber = claimNumber; }

    public LocalDateTime getClaimDate() { return claimDate; }

    public void setClaimDate(LocalDateTime claimDate) { this.claimDate = claimDate; }

    public Double getClaimAmount() { return claimAmount; }

    public void setClaimAmount(Double claimAmount) { this.claimAmount = claimAmount; }

    public String getClaimStatus() { return claimStatus; }

    public void setClaimStatus(String claimStatus) { this.claimStatus = claimStatus; }

    public PolicyDto getPolicy() { return policy; }

    public void setPolicy(PolicyDto policy) { this.policy = policy; }

    public Set<PaymentDto> getPayments() { return payments; }

    public void setPayments(Set<PaymentDto> payments) { this.payments = payments; }

    @Override
    public String toString() { return String.format("Claim ID: %d\nNumber: %s\nDate: %s\nAmount: %.2f\nStatus: %s\nPolicy: %s\nPayments: %s", claimId, claimNumber, claimDate, claimAmount, claimStatus, policy, payments); }
}
