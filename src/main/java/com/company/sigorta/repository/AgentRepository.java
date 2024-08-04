package com.company.sigorta.repository;

import com.company.sigorta.model.AgentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<AgentModel, Integer>
{

}
