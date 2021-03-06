package com.mitrais.carrot.controllers;

import com.mitrais.carrot.config.Config;
import com.mitrais.carrot.models.Rewards;
import com.mitrais.carrot.repositories.RewardsRepository;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(Config.BASE_URI_API)
public class RewardsController {

    @Autowired
    public RewardsRepository rewardsRepository;

    @GetMapping("/rewards")
    @ResponseBody
    public Iterable<Rewards> all() {
        return rewardsRepository.findAll();
    }

    @PostMapping("/rewards")
    @ResponseBody
    public Rewards save(@Valid @RequestBody Rewards body) {
        return rewardsRepository.save(body);
    }

    @GetMapping("/rewards/{id}")
    @ResponseBody
    public Optional<Rewards> detail(@PathVariable Integer id) {
        return rewardsRepository.findById(id);
    }

    @PutMapping("/rewards/{id}")
    @ResponseBody
    public Rewards update(@PathVariable Integer id, @Valid @RequestBody Rewards body) {
        Optional<Rewards> model = rewardsRepository.findById(id);
        Rewards sl = model.get();
        BeanUtils.copyProperties(body, sl);
        sl.setId(id);
        return rewardsRepository.save(sl);
    }

    @DeleteMapping("/rewards/{id}")
    @ResponseBody
    public String delete(@PathVariable Integer id) {
        Optional<Rewards> sl = rewardsRepository.findById(id);
        sl.get().setIsDeteled(1);
        rewardsRepository.save(sl.get());
        return "";
    }
}
