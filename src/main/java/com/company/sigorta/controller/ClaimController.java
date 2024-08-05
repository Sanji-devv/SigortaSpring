package com.company.sigorta.controller;
import com.company.sigorta.model.ClaimModel;
import com.company.sigorta.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController
{
    private final ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) { this.claimService = claimService; }

    @GetMapping("/list_claim")
    public List<ClaimModel> getClaims() { return claimService.getClaims(); }

    @GetMapping("/claim_id/{id}")
    public ResponseEntity<ClaimModel> getClaimById(@PathVariable Integer id) { return ResponseEntity.ok(claimService.getClaimById(id)); }

    @PostMapping("/add_claim")
    public ResponseEntity<ClaimModel> createClaim(@RequestBody ClaimModel claim) { return ResponseEntity.ok(claimService.createClaim(claim)); }

    @PutMapping("/update_claim/{id}")
    public ResponseEntity<ClaimModel> updateClaim(@PathVariable Integer id, @RequestBody ClaimModel claim) { return ResponseEntity.ok(claimService.updateClaim(id, claim)); }

    @DeleteMapping("/delete_claim/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Integer id)
    {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}