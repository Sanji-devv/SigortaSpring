package com.company.sigorta.model;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "policy")
public class PolicyModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyId;
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

    public UserModel getUser() { return user; }

    public void setUser(UserModel user) { this.user = user; }

    public Set<ClaimModel> getClaims() { return claims; }

    public void setClaims(Set<ClaimModel> claims) { this.claims = claims; }
}