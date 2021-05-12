package ru.kostenko.MilkDairyManagementSistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostenko.MilkDairyManagementSistem.models.User;

import java.util.Optional;

public interface MilkUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
