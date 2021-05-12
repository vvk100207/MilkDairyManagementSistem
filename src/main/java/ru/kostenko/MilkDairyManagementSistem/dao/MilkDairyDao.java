package ru.kostenko.MilkDairyManagementSistem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostenko.MilkDairyManagementSistem.models.MilkDairy;
import ru.kostenko.MilkDairyManagementSistem.repository.MilkDairyRepository;

import java.util.List;

    @Service
    public class MilkDairyDao {


        private final MilkDairyRepository milkDairyRepository;

        @Autowired
        public MilkDairyDao(MilkDairyRepository milkDairyRepository) {
            this.milkDairyRepository = milkDairyRepository;
        }

        public void saveMilkDairy(MilkDairy milkDairy){
            milkDairyRepository.save(milkDairy);
        }

        public List<MilkDairy>AllMilkDairies(){
            return milkDairyRepository.findAll();
        }



        public void deleteMilkRecordById(Long id){
           milkDairyRepository.deleteById(id);
        }

        public MilkDairy updateMilkRecordById(Long id){
            return (MilkDairy) milkDairyRepository.getOne(id);

        }

        public void findMilkRecordById(Long id){
            milkDairyRepository.findById(id);
        }
    }


