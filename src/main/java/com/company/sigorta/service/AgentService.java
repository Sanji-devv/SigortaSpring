package com.company.sigorta.service;
import com.company.sigorta.model.AgentModel;
import com.company.sigorta.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AgentService
{
    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) { this.agentRepository = agentRepository; }

    public List<AgentModel> getAgents() { return agentRepository.findAll(); }

    public AgentModel getAgentById(Integer id) { return agentRepository.findById(id).orElseThrow(() -> new RuntimeException("Agent not found")); }

    public AgentModel getAgentByName(String name) { return agentRepository.findByAgentName(name).orElseThrow(() -> new RuntimeException("Agent not found")); }

    public AgentModel getAgentBySurname(String surname) { return agentRepository.findByAgentSurname(surname).orElseThrow(() -> new RuntimeException("Agent not found")); }

    public AgentModel getAgentByEmail(String email) { return agentRepository.findByAgentEmail(email).orElseThrow(() -> new RuntimeException("Agent not found")); }

    public AgentModel getAgentByCode(String code) { return agentRepository.findByAgentCode(code).orElseThrow(() -> new RuntimeException("Agent not found")); }

    public AgentModel createAgent(AgentModel agent) { return agentRepository.save(agent); }

    public AgentModel updateAgent(Integer id, AgentModel agent)
    {
        AgentModel existingAgent = getAgentById(id);
        existingAgent.setAgentName(agent.getAgentName());
        existingAgent.setAgentSurname(agent.getAgentSurname());
        existingAgent.setAgentEmail(agent.getAgentEmail());
        existingAgent.setAgentCode(agent.getAgentCode());
        return agentRepository.save(existingAgent);
    }

    public void deleteAgent(Integer id) { agentRepository.deleteById(id); }
}