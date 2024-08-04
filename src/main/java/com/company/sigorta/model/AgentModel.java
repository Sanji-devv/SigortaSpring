package com.company.sigorta.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "agents")
public class AgentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String agentCode;

    @ManyToMany
    @JoinTable(
            name = "agent_customers",
            joinColumns = @JoinColumn(name = "agent_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<UserModel> users;
}
