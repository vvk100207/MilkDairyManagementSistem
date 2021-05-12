package ru.kostenko.MilkDairyManagementSistem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostenko.MilkDairyManagementSistem.models.MilkAccount;
import ru.kostenko.MilkDairyManagementSistem.repository.MilkAccountRepository;

import java.util.List;

@Service
public class MilkAccountDao {

    private final MilkAccountRepository milkAccountRepository;

    @Autowired
    public MilkAccountDao(MilkAccountRepository milkAccountRepository) {
        this.milkAccountRepository = milkAccountRepository;
    }


        public List<MilkAccount> AllMilkAccounts(){
            return milkAccountRepository.findAll();
        }


        public void deleteMilkAccountById (Long id){
            milkAccountRepository.deleteById(id);
        }

        public MilkAccount updateMilkAccountById (Long id){
            return (MilkAccount) milkAccountRepository.getOne(id);

        }

        public void findMilkAccountById (Long id){
            milkAccountRepository.getOne(id);
        }

        public void saveMilkAccount(MilkAccount milkAccount){
        milkAccountRepository.save(milkAccount);
        }
    }
