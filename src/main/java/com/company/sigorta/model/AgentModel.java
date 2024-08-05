package com.company.sigorta.model;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "agent")
public class AgentModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agentId;
    private String agentName;
    private String agentSurname;
    private String agentEmail;
    private String agentCode;

    @ManyToMany
    @JoinTable(name = "agent_user_name", joinColumns = @JoinColumn(name = "agent_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserModel> users;

    public Integer getAgentId() { return agentId; }

    public void setAgentId(Integer agentId) { this.agentId = agentId; }

    public String getAgentName() { return agentName; }

    public void setAgentName(String firstName) { this.agentName = firstName; }

    public String getAgentSurname() { return agentSurname; }

    public void setAgentSurname(String lastName) { this.agentSurname = lastName; }

    public String getAgentEmail() { return agentEmail; }

    public void setAgentEmail(String email) { this.agentEmail = email; }

    public String getAgentCode() { return agentCode; }

    public void setAgentCode(String agentCode) { this.agentCode = agentCode; }

    public Set<UserModel> getUsers() { return users; }

    public void setUsers(Set<UserModel> users) { this.users = users; }
}
