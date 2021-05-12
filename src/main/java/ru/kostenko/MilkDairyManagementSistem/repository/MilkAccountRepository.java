package ru.kostenko.MilkDairyManagementSistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostenko.MilkDairyManagementSistem.models.MilkAccount;

public interface MilkAccountRepository extends JpaRepository<MilkAccount, Long> {



}
