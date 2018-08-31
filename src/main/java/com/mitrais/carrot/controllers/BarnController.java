package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.Barn;
import com.mitrais.carrot.repositories.BarnRepository;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class BarnController {

	@Autowired
    public BarnRepository barnRepository;

    @GetMapping("/barns")
    @ResponseBody
    public Iterable<Barn> getAll() {
        return barnRepository.findAll();
    }  

    @PostMapping("/barns")
    @ResponseBody
    public Barn save(@Valid @RequestBody Barn body) {
        return barnRepository.save(body);
    }

    @GetMapping("/barns/{id}")
    @ResponseBody
    public Optional<Barn> detail(@PathVariable Integer id) {
        return barnRepository.findById(id);
    }

    @PutMapping("/barns/{id}")
    @ResponseBody
    public Barn update(@PathVariable Integer id, @Valid @RequestBody Barn body) {
        Optional<Barn> model = barnRepository.findById(id);
        Barn barn = model.get();
        BeanUtils.copyProperties(body, barn);
        barn.setId(id);
        return barnRepository.save(barn);
    }

    @DeleteMapping("/barns/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        Optional<Barn> sl = barnRepository.findById(id);
        sl.get().setIsDeteled(1);
        barnRepository.save(sl.get());
        return "";
    }
}
