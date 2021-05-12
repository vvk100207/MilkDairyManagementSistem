package ru.kostenko.MilkDairyManagementSistem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostenko.MilkDairyManagementSistem.dao.MilkDairyDao;
import ru.kostenko.MilkDairyManagementSistem.models.MilkDairy;

import java.util.List;

@Controller
public class MainController {

    private final MilkDairyDao milkDairyDao;


    public MainController(MilkDairyDao milkDairyDao) {
        this.milkDairyDao = milkDairyDao;

    }

    // получение главной страницы
    @GetMapping("/milk")
    public String getMainPage(){
        return "/main";
    }

   @GetMapping("/dairyRecords")
   public String getRecords(Model model){
   List<MilkDairy> milkDairies= milkDairyDao.AllMilkDairies();     // Общий списком записей закупки молока
   model.addAttribute("milkDairies", milkDairies);
   return"/dairyRecords";

    }
    @GetMapping("/dairyRecords-delete/{id}")
    public String deleteRecordById(@PathVariable("id") Long id){   // удаление из общего списка записей закупки молока
    milkDairyDao.deleteMilkRecordById(id);
    return "redirect:/dairyRecords";
    }


//    @GetMapping("/models-update/{id}")
//    public String getFormUpdate(@PathVariable("id") Long id, Model model){
//        MilkDairy models = milkDairyDao.updateMilkRecordById(id);         // получение страницы обновления записи закупки молока
//        model.addAttribute("models", models );
//        return"/models-update";
//    }
//    @PostMapping("/models-update")
//    public String updateMilkDairyRecord(MilkDairy models){
//    milkDairyDao.saveMilkDairy(models);                     //обновление самой записи закупки молока
//    return "redirect:/dairyRecords";
//    }


    @GetMapping ("/milkDairy")
    public String getMilkDairyPage(MilkDairy milkDairy){          //получение страницы ввода данных закупки молока
    return "milkDairy";
    }

    @PostMapping("/milkDairy")
    public String getNewMilkDairy( MilkDairy milkDairy) {         // сохранение записи закупки молока после ввода в общую базу данных
        milkDairyDao.saveMilkDairy(milkDairy);
    return "redirect:/milkDairy";
    }




//    @GetMapping("/newAccount")
//    public String getNewAccountPage() {                          //получение страницы newAccount
//        return "newAccount";
//    }



}