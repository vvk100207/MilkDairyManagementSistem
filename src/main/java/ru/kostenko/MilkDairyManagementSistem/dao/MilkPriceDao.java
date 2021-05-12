package ru.kostenko.MilkDairyManagementSistem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kostenko.MilkDairyManagementSistem.models.MilkPrice;
import ru.kostenko.MilkDairyManagementSistem.repository.MilkPiceRepository;

import java.util.List;

@Service
public class MilkPriceDao {

    private final MilkPiceRepository milkPiceRepository;

@Autowired
    public MilkPriceDao(MilkPiceRepository milkPiceRepository) {
        this.milkPiceRepository = milkPiceRepository;
    }

    public void savePrice (MilkPrice milkPrice){
        milkPiceRepository.save(milkPrice);
    }

    public List<MilkPrice> allPrices() {
       return milkPiceRepository.findAll();
    }

    public void deletePriceById(Long id) {
        milkPiceRepository.deleteById(id);
    }

//    public MilkPrice updatePriceById(Long id){
//    return  milkPiceRepository.getOne(id);
//    }
}
