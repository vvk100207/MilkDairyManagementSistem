package ru.kostenko.MilkDairyManagementSistem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostenko.MilkDairyManagementSistem.dao.MilkSecurityDao;
import ru.kostenko.MilkDairyManagementSistem.models.MilkPrice;
import ru.kostenko.MilkDairyManagementSistem.models.User;
import ru.kostenko.MilkDairyManagementSistem.service.UserRepr;
import ru.kostenko.MilkDairyManagementSistem.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SecurityController {

    private final UserService userService;

    private  final MilkSecurityDao milkSecurityDao;

    @Autowired
    public SecurityController(UserService userService, MilkSecurityDao milkSecurityDao) {
        this.userService = userService;
        this.milkSecurityDao = milkSecurityDao;
    }

    // получение страницы входа
    @GetMapping("/login")
    public String GetLoginPage() {
        return "login";
    }

     //получение страницы регистрации
    @GetMapping("/register")
    public String GetRegisterPage(Model model) {
        model.addAttribute("user", new UserRepr());
        return "register";
    }

// регистрация нового пользователя системой
    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") UserRepr userRepr, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (!userRepr.getPassword().equals(userRepr.getRepeatPassword())) {
            bindingResult.rejectValue("password", "", "Пароли не совпадают");
            return "register";
        }
        userService.create(userRepr);
        return "redirect:/users";
    }


        @GetMapping("/users")
        public String getUsers(Model model) {
        List<User> users = milkSecurityDao.getAllUsers();     // Общий список записей пользователей
        model.addAttribute("users", users);
        return "/users";

}

    @GetMapping("/users-delete/{id}")
    public String deleteUserById(@PathVariable("id") Long id){   // удаление из общего списка пользователей
        milkSecurityDao.deleteUserById(id);
        return "redirect:/users";
    }
}
