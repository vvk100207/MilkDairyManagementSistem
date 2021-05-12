package ru.kostenko.MilkDairyManagementSistem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostenko.MilkDairyManagementSistem.dao.MilkAccountDao;
import ru.kostenko.MilkDairyManagementSistem.models.MilkAccount;

import java.util.List;

@Controller
public class AccountController {

    private final MilkAccountDao milkAccountDao;
@Autowired
    public AccountController(MilkAccountDao milkAccountDao) {
        this.milkAccountDao = milkAccountDao;
    }

    @GetMapping("/searchAccount")
    public String getRecords(Model model){
        List<MilkAccount> milkAccounts= milkAccountDao.AllMilkAccounts();     // Общий списком записей поставщиков
        model.addAttribute("milkAccounts", milkAccounts);
        return"/searchAccount";

    }
    @GetMapping("/searchAccount-delete/{id}")
    public String deleteAccountById(@PathVariable("id") Long id){   // удаление из общего списка записей поставщиков
        milkAccountDao.deleteMilkAccountById(id);
        return "redirect:/searchAccount";
    }

    @PostMapping("/searchAccount")
    public String saveAccount(MilkAccount milkAccount){
   milkAccountDao.saveMilkAccount(milkAccount);                    //сохранение в базе нового поставщика
    return "redirect:/searchAccount" ;
    }
}
