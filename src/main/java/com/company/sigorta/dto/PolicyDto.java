package com.company.sigorta.dto;
import java.util.Set;

public class PolicyDto
{
    private Integer policyId;
    private String policyNumber;
    private String policyType;
    private String startDate;
    private String endDate;
    private Double premiumAmount;

    private UserDto user;
    private Set<ClaimDto> claims;

    public PolicyDto() {}

    public PolicyDto(Integer policyId, String policyNumber, String policyType, String startDate, String endDate, Double premiumAmount, UserDto user, Set<ClaimDto> claims)
    {
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premiumAmount = premiumAmount;
        this.user = user;
        this.claims = claims;
    }

    public Integer getPolicyId() { return policyId; }

    public void setPolicyId(Integer policyId) { this.policyId = policyId; }

    public String getPolicyNumber() { return policyNumber; }

    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }

    public String getPolicyType() { return policyType; }

    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public Double getPremiumAmount() { return premiumAmount; }

    public void setPremiumAmount(Double premiumAmount) { this.premiumAmount = premiumAmount; }

    public UserDto getUser() { return user; }

    public void setUser(UserDto user) { this.user = user; }

    public Set<ClaimDto> getClaims() { return claims; }

    public void setClaims(Set<ClaimDto> claims) { this.claims = claims; }

    @Override
    public String toString() { return String.format("Policy ID: %d\nNumber: %s\nType: %s\nStart Date: %s\nEnd Date: %s\nPremium Amount: %.2f\nUser: %s\nClaims: %s", policyId, policyNumber, policyType, startDate, endDate, premiumAmount, user, claims); }
}

