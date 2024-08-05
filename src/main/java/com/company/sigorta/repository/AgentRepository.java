package com.company.sigorta.repository;
import com.company.sigorta.model.AgentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<AgentModel, Integer>
{
    Optional<AgentModel> findByAgentName(String agentName);
    Optional<AgentModel> findByAgentSurname(String agentSurname);
    Optional<AgentModel> findByAgentEmail(String agentEmail);
    Optional<AgentModel> findByAgentCode(String agentCode);
}
