package com.example.s18d1jpa.controller;


import com.example.s18d1jpa.dao.BurgerDao;
import com.example.s18d1jpa.entity.Burger;
import com.example.s18d1jpa.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDao burgerDao;
    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkname(burger.getName());
        return burgerDao.save(burger);
    }


}
