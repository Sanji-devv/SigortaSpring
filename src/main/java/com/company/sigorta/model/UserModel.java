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
@Table(name = "user")

public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userSurname;
    private String userEmail;

    @OneToMany(mappedBy = "user")
    private Set<PolicyModel> policies;
}
