package com.company.sigorta.model;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
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

    public Integer getUserId() { return userId; }

    public void setUserId(Integer id) { this.userId = id; }

    public String getUserName() { return userName; }

    public void setUserName(String name) { this.userName = name; }

    public String getUserSurname() { return userSurname; }

    public void setUserSurname(String surname) { this.userSurname = surname; }

    public String getUserEmail() { return userEmail; }

    public void setUserEmail(String email) { this.userEmail = email; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(userId, userModel.userId) && Objects.equals(userName, userModel.userName) && Objects.equals(userSurname, userModel.userSurname) && Objects.equals(userEmail, userModel.userEmail);
    }

    @Override
    public int hashCode() { return Objects.hash(userId, userName, userSurname, userEmail); }
}
