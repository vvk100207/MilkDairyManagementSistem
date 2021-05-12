package ru.kostenko.MilkDairyManagementSistem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostenko.MilkDairyManagementSistem.dao.MilkPriceDao;
import ru.kostenko.MilkDairyManagementSistem.models.MilkPrice;

import java.util.List;


@Controller
public class PriceController {

  private final MilkPriceDao milkPriceDao;

@Autowired
    public PriceController(MilkPriceDao milkPriceDao) {
        this.milkPriceDao = milkPriceDao;
    }

    @GetMapping("/setFatePrice")
    public String getAllPrices(Model model ) {
        List<MilkPrice> milkPrices =milkPriceDao.allPrices();
        model.addAttribute("milkPrices", milkPrices);    // Получение страницы с общим списком цен
        return "setFatePrice";
    }

    @PostMapping("/setFatePrice")
    public String getNewMilkDairy( MilkPrice milkPrice) {         // запись цены в общую базу данных
      milkPriceDao.savePrice(milkPrice);
        return "redirect:/setFatePrice";
    }

    @GetMapping("/setFatePrice-delete/{id}")
    public String deletePriceById(@PathVariable("id") Long id){   // удаление из общего списка записей цены
        milkPriceDao.deletePriceById(id);
        return "redirect:/setFatePrice";
    }

}
