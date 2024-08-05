package com.company.sigorta.dto;

public class PaymentDto
{
    private Integer paymentId;
    private String paymentDate;
    private Double paymentAmount;
    private String paymentType;

    private ClaimDto claim;

    public PaymentDto() {}

    public PaymentDto(Integer paymentId, String paymentDate, Double paymentAmount, String paymentType, ClaimDto claim)
    {
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.paymentType = paymentType;
        this.claim = claim;
    }

    public Integer getPaymentId() { return paymentId; }

    public void setPaymentId(Integer paymentId) { this.paymentId = paymentId; }

    public String getPaymentDate() { return paymentDate; }

    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public Double getPaymentAmount() { return paymentAmount; }

    public void setPaymentAmount(Double paymentAmount) { this.paymentAmount = paymentAmount; }

    public String getPaymentType() { return paymentType; }

    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }

    public ClaimDto getClaim() { return claim; }

    public void setClaim(ClaimDto claim) { this.claim = claim; }

    @Override
    public String toString() { return String.format("Payment ID: %d\nDate: %s\nAmount: %.2f\nType: %s\nClaim: %s", paymentId, paymentDate, paymentAmount, paymentType, claim); }
}

