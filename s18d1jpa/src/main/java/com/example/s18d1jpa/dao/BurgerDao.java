package com.example.s18d1jpa.dao;

import com.example.s18d1jpa.entity.BreadType;
import com.example.s18d1jpa.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    Burger findById(int id);
    Burger update(Burger newburger);
    Burger remove(int id);
    List<Burger> findByPrice(int price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findAll();
    List<Burger> findByContent(String content);
}
