package com.company.sigorta.repository;
import com.company.sigorta.model.ClaimModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClaimRepository extends JpaRepository<ClaimModel, Integer>
{
    Optional<ClaimModel> findByClaimNumber(String claimNumber);
    Optional<ClaimModel> findByClaimStatus(String claimStatus);
}

