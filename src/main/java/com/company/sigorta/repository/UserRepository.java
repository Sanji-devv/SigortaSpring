package com.company.sigorta.repository;
import com.company.sigorta.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>
{
    Optional<UserModel> findByUserName(String userName);
    Optional<UserModel> findByUserEmail(String email);
    Optional<UserModel> findByFirstName(String firstname);
    Optional<UserModel> findByLastName(String lastname);
    Boolean existsByUserName(String username);
    Boolean existsByUserEmail(String email);
}
