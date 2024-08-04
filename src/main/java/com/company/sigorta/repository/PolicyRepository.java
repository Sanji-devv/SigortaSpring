package com.company.sigorta.repository;

import com.company.sigorta.model.PolicyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<PolicyModel, Integer>
{

}