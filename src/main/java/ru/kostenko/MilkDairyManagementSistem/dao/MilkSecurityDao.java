package ru.kostenko.MilkDairyManagementSistem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostenko.MilkDairyManagementSistem.models.MilkPrice;
import ru.kostenko.MilkDairyManagementSistem.models.User;
import ru.kostenko.MilkDairyManagementSistem.repository.MilkUserRepository;

import java.util.List;

@Service
public class MilkSecurityDao {

   public MilkUserRepository milkUserRepository;

@Autowired
    public MilkSecurityDao(MilkUserRepository milkUserRepository) {
        this.milkUserRepository = milkUserRepository;
    }

    public List<User> getAllUsers(){
        return milkUserRepository.findAll();
    }

    public void deleteUserById(Long id) {
        milkUserRepository.deleteById(id);
    }
}
