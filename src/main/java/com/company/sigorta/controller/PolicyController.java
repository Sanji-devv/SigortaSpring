package com.company.sigorta.controller;
import com.company.sigorta.model.PolicyModel;
import com.company.sigorta.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController
{
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) { this.policyService = policyService; }

    @GetMapping("/list_policy")
    public List<PolicyModel> getPolicies() { return policyService.getPolicies(); }

    @GetMapping("/policy_id/{id}")
    public ResponseEntity<PolicyModel> getPolicyById(@PathVariable Integer id) { return ResponseEntity.ok(policyService.getPolicyById(id)); }

    @PostMapping("/add_policy")
    public ResponseEntity<PolicyModel> createPolicy(@RequestBody PolicyModel policy) { return ResponseEntity.ok(policyService.createPolicy(policy)); }

    @PutMapping("/update_policy/{id}")
    public ResponseEntity<PolicyModel> updatePolicy(@PathVariable Integer id, @RequestBody PolicyModel policy) { return ResponseEntity.ok(policyService.updatePolicy(id, policy)); }

    @DeleteMapping("/delete_policy/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Integer id)
    {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}