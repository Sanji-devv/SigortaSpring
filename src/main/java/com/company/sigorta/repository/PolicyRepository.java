package com.company.sigorta.repository;
import com.company.sigorta.model.PolicyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<PolicyModel, Integer>
{
    Optional<PolicyModel> findByPolicyNumber(String policyNumber);
    Optional<PolicyModel> findByPolicyType(String policyType);
}