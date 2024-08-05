package com.company.sigorta.repository;
import com.company.sigorta.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer>
{
    Optional<UserModel> findByUserName(String name);
    Optional<UserModel> findByUserSurname(String surname);
    Optional<UserModel> findByUserEmail(String email);
}
