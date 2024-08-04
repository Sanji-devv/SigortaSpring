package com.company.sigorta.repository;

import com.company.sigorta.model.ClaimModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<ClaimModel, Integer>
{

}

