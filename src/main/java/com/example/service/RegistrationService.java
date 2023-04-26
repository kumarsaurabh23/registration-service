package com.example.service;

import com.example.controller.Controller;
import com.example.dao.RegistrationDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;
    public void saveUser(Controller.User user) {
        User u = new User();
        u.setName(user.name());
        u.setEmail(user.email());
        registrationDao.save(u);
    }

    public List<Controller.User> getUsers() {
        return registrationDao.findAll().stream()
                        .map(u -> new Controller.User(u.getId(), u.getName(), u.getEmail()))
                        .collect(Collectors.toList());
    }

    public Controller.User getUserByName(String name) {
        return registrationDao.findByName(name).stream()
                .map(u -> new Controller.User(u.getId(), u.getName(), u.getEmail()))
                .findFirst()
                .orElse(new Controller.User(null, null, null));
    }

    public List<Controller.User> cancelUser(Integer id) {
        registrationDao.deleteById(id);
        return getUsers();
    }
}
