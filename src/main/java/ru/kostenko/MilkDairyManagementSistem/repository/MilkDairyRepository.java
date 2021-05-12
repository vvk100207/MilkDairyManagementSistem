package ru.kostenko.MilkDairyManagementSistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostenko.MilkDairyManagementSistem.models.MilkDairy;

public interface MilkDairyRepository extends JpaRepository<MilkDairy,Long> {
}
