package ru.kostenko.MilkDairyManagementSistem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kostenko.MilkDairyManagementSistem.models.User;
import ru.kostenko.MilkDairyManagementSistem.repository.MilkUserRepository;

@Service
public class UserService {

    private final MilkUserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(MilkUserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void create(UserRepr userRepr) {
       User user = new User();
        user.setUsername(userRepr.getUsername());
        user.setPassword(passwordEncoder.encode(userRepr.getPassword()));
        repository.save(user);
    }
}

