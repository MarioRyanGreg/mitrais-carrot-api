package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.Bazaar;
import com.mitrais.carrot.repositories.BazaarRepository;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class BazaarController {

    @Autowired
    BazaarRepository bazaarRepository;

    @GetMapping("/bazaars")
    public Iterable<Bazaar> all() {
        return bazaarRepository.findAll();
    }

    @PostMapping("/bazaars")
    public Bazaar save(@RequestBody Bazaar body) {
        return bazaarRepository.save(body);
    }

    @GetMapping("/bazaars/{id}")
    public Optional<Bazaar> show(@PathVariable Integer id) {
        return bazaarRepository.findById(id);
    }

    @PutMapping("/bazaars/{id}")
    public Bazaar update(@PathVariable Integer id, @Valid @RequestBody Bazaar body) {
        Optional<Bazaar> model = bazaarRepository.findById(id);
        Bazaar sl = model.get();
        BeanUtils.copyProperties(body, sl);
        sl.setId(id);
        return bazaarRepository.save(sl);
    }

    @DeleteMapping("/bazaars/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Bazaar> sl = bazaarRepository.findById(id);
        sl.get().setIsDeteled(1);
        bazaarRepository.save(sl.get());
        return "";
    }
}
