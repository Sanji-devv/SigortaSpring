package com.company.sigorta.service;
import com.company.sigorta.model.ClaimModel;
import com.company.sigorta.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaimService
{
    private final ClaimRepository claimRepository;

    @Autowired
    public ClaimService(ClaimRepository claimRepository) { this.claimRepository = claimRepository; }

    public List<ClaimModel> getClaims() { return claimRepository.findAll(); }

    public ClaimModel getClaimById(Integer id) { return claimRepository.findById(id).orElseThrow(() -> new RuntimeException("Claim not found")); }

    public ClaimModel getClaimByNumber(String number) { return claimRepository.findByClaimNumber(number).orElseThrow(() -> new RuntimeException("Claim not found")); }

    public ClaimModel getClaimByStatus(String status) { return claimRepository.findByClaimStatus(status).orElseThrow(() -> new RuntimeException("Claim not found")); }

    public ClaimModel createClaim(ClaimModel claim) { return claimRepository.save(claim); }

    public ClaimModel updateClaim(Integer id, ClaimModel claim)
    {
        ClaimModel existingClaim = getClaimById(id);
        existingClaim.setClaimNumber(claim.getClaimNumber());
        existingClaim.setClaimDate(claim.getClaimDate());
        existingClaim.setClaimAmount(claim.getClaimAmount());
        existingClaim.setClaimStatus(claim.getClaimStatus());
        return claimRepository.save(existingClaim);
    }

    public void deleteClaim(Integer id) { claimRepository.deleteById(id); }
}