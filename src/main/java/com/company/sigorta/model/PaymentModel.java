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

    public Integer getPaymentId() { return paymentId; }

    public void setPaymentId(Integer paymentId) { this.paymentId = paymentId; }

    public String getPaymentDate() { return paymentDate; }

    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public Double getPaymentAmount() { return paymentAmount; }

    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }

    public String getPaymentType() { return paymentType; }

    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public ClaimModel getClaim() { return claim; }

    public void setClaim(ClaimModel claim) { this.claim = claim; }
}

