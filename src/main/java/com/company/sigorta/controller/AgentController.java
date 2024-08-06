package com.company.sigorta.controller;
import com.company.sigorta.model.AgentModel;
import com.company.sigorta.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController
{
    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) { this.agentService = agentService; }

    @GetMapping("/list_agent")
    public List<AgentModel> getAgents() { return agentService.getAgents(); }

    @GetMapping("/agent_id/{id}")
    public ResponseEntity<AgentModel> getAgentById(@PathVariable Integer id) { return ResponseEntity.ok(agentService.getAgentById(id)); }

    @GetMapping("/agent_name/{name}")
    public ResponseEntity<AgentModel> getAgentByName(@PathVariable String name) { return ResponseEntity.ok(agentService.getAgentByName(name)); }

    @GetMapping("/agent_email/{email}")
        public ResponseEntity<AgentModel> getAgentByEmail(@PathVariable String email) { return ResponseEntity.ok(agentService.getAgentByEmail(email)); }

    @GetMapping("/agent_code/{code}")
    public ResponseEntity<AgentModel> getAgentByCode(@PathVariable String code) { return ResponseEntity.ok(agentService.getAgentByCode(code)); }

    @PostMapping("/add_agent")
    public ResponseEntity<AgentModel> createAgent(@RequestBody AgentModel agent) { return ResponseEntity.ok(agentService.createAgent(agent)); }

    @PutMapping("/update_agent/{id}")
    public ResponseEntity<AgentModel> updateAgent(@PathVariable Integer id, @RequestBody AgentModel agent) { return ResponseEntity.ok(agentService.updateAgent(id, agent)); }

    @DeleteMapping("/delete_agent/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Integer id)
    {
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }
}
