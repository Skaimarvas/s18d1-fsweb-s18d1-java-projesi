package com.example.s18d1jpa.dao;

import com.example.s18d1jpa.entity.BreadType;
import com.example.s18d1jpa.entity.Burger;
import jakarta.persistence.EntityManager;

import java.util.List;

/**
 * Create update ve delete işlemleri için EntityManagerı kullanacağız.
 *
 */

public class BurgerDaoImpl implements BurgerDao {
    private final EntityManager entityManager;

    @Override
    public Burger save(Burger burger) {
        return null;
    }

    @Override
    public Burger findById(int id) {
        return null;
    }

    @Override
    public Burger update(Burger newburger) {
        return null;
    }

    @Override
    public Burger remove(int id) {
        return null;
    }

    @Override
    public List<Burger> findByPrice(int price) {
        return null;
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        return null;
    }

    @Override
    public List<Burger> findAll() {
        return null;
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }
}
