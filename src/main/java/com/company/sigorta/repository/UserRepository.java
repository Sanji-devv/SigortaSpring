package com.company.sigorta.repository;

import com.company.sigorta.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer>
{
    Optional<UserModel> findByName(String name);
    Optional<UserModel> findBySurname(String surname);
    Optional<UserModel> findByEmail(String email);
}
