package com.company.sigorta.dto;

public class AgentDto
{
    private Integer agentId;
    private String agentCode;
    private String agentName;
    private String agentSurname;
    private String email;

    public AgentDto() {}

    public AgentDto(Integer agentId, String agentCode, String firstName, String lastName, String email)
    {
        this.agentId = agentId;
        this.agentCode = agentCode;
        this.agentName = firstName;
        this.agentSurname = lastName;
        this.email = email;
    }

    public Integer getAgentId() { return agentId; }

    public void setAgentId(Integer agentId) { this.agentId = agentId; }

    public String getAgentCode() { return agentCode; }

    public void setAgentCode(String agentCode) { this.agentCode = agentCode; }

    public String getAgentName() { return agentName; }

    public void setAgentName(String agentName) { this.agentName = agentName; }

    public String getAgentSurname() { return agentSurname; }

    public void setAgentSurname(String agentSurname) { this.agentSurname = agentSurname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() { return String.format("Agent ID: %d\nCode: %s\nFirst Name: %s\nLast Name: %s\nEmail: %s", agentId, agentCode, agentName, agentSurname, email); }
}
