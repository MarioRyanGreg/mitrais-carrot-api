package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.User;
import com.mitrais.carrot.repositories.UserRepository;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> all() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User save(@RequestBody User body) {
        return userRepository.save(body);
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PutMapping("/users/{id}")
    @ResponseBody
    public User update(@PathVariable Integer id,@Valid @RequestBody User body) {
        Optional<User> user = userRepository.findById(id);
        User u = user.get();
        BeanUtils.copyProperties(body, u);
        u.setId(id);
        return userRepository.save(body);
    }

    @DeleteMapping("/users/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        Optional<User> sl = userRepository.findById(id);
        sl.get().setIsDeteled(1);
        userRepository.save(sl.get());
        return "";
    }
}
