package ru.kostenko.MilkDairyManagementSistem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kostenko.MilkDairyManagementSistem.repository.MilkUserRepository;

import java.util.Collections;

@Service
public class UserAuthService implements UserDetailsService {

    private final MilkUserRepository repository;

    @Autowired
    public UserAuthService(MilkUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(user -> new User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("USER"))
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }
}