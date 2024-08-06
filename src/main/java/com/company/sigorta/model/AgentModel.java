package com.company.sigorta.model;
import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
