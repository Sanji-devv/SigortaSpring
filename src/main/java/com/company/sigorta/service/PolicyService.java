package com.company.sigorta.service;
import com.company.sigorta.model.PolicyModel;
import com.company.sigorta.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyService
{
    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) { this.policyRepository = policyRepository; }

    public List<PolicyModel> getPolicies() { return policyRepository.findAll(); }

    public PolicyModel getPolicyById(Integer id) { return policyRepository.findById(id).orElseThrow(() -> new RuntimeException("Policy not found")); }

    public PolicyModel getPolicyByNumber(String number) { return policyRepository.findByPolicyNumber(number).orElseThrow(() -> new RuntimeException("Policy not found")); }

    public PolicyModel getPolicyByType(String type) { return policyRepository.findByPolicyType(type).orElseThrow(() -> new RuntimeException("Policy not found")); }

    public PolicyModel createPolicy(PolicyModel policy) { return policyRepository.save(policy); }

    public PolicyModel updatePolicy(Integer id, PolicyModel policy)
    {
        PolicyModel existingPolicy = getPolicyById(id);
        existingPolicy.setPolicyNumber(policy.getPolicyNumber());
        existingPolicy.setPolicyType(policy.getPolicyType());
        existingPolicy.setStartDate(policy.getStartDate());
        existingPolicy.setEndDate(policy.getEndDate());
        existingPolicy.setPremiumAmount(policy.getPremiumAmount());
        return policyRepository.save(existingPolicy);
    }

    public void deletePolicy(Integer id) { policyRepository.deleteById(id); }
}