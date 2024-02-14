package com.example.s18d1jpa.dao;

import com.example.s18d1jpa.entity.BreadType;
import com.example.s18d1jpa.entity.Burger;
import com.example.s18d1jpa.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Create update ve delete işlemleri için EntityManagerı kullanacağız.
 * EntityManager türünde bir nesne oluşturmak ve bu nesneyi BurgerDaoImpl sınıfına enjekte etmek için @Autowired anotasyonu kullandık.
 * Bir işlem sınırı içinde işlem başarılıysa değişiklikler kalıcı hale gelir
 * ama hata oluşurssa @Transactional anotasyonu aracılığıyla değişiklikler geri alınır.(rollback)
 * findAll methodunda TypedQuery kullanmamızın nedeni tip güvenliği, performans ve optimizasyon,kod okunabilirliği ve hata ayıklamadan dolayıdır.
 *
 */

public class BurgerDaoImpl implements BurgerDao {
    private final EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(int id) {
        Burger burger = entityManager.find(Burger.class,id);
        if(burger == null){
            throw new BurgerException("Burger with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
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
        TypedQuery<Burger> foundAll = entityManager.createQuery("SELECT b from Burger b", Burger.class);
        return foundAll.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }
}
