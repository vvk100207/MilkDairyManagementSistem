package ru.kostenko.MilkDairyManagementSistem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kostenko.MilkDairyManagementSistem.models.MilkPrice;

public interface MilkPiceRepository extends JpaRepository<MilkPrice,Long> {
}
