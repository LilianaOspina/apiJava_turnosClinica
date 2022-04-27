package com.dh.proyectoIntegrador.service;

import com.dh.proyectoIntegrador.entities.AppUser;
import com.dh.proyectoIntegrador.entities.AppUsuarioRoles;
import com.dh.proyectoIntegrador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository repoUser;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String pass= passwordEncoder.encode("juju");

        repoUser.save(
                new AppUser(
                        "Tom",
                        "tomloco",
                        "tomcito@gmail.com",
                        pass,
                        AppUsuarioRoles.ROLE_USER));
        repoUser.save(
                new AppUser(
                        "Liliana",
                        "li",
                        "lili@gmail.com",
                        pass,
                        AppUsuarioRoles.ROLE_ADMIN));
    }
}
