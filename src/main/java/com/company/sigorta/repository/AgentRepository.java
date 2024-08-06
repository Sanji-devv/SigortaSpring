package com.company.sigorta.repository;
import com.company.sigorta.model.AgentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<AgentModel, Integer>
{
    Optional<AgentModel> findByAgentName(String name);
    Optional<AgentModel> findByAgentEmail(String email);
    Optional<AgentModel> findByAgentCode(String code);
}
