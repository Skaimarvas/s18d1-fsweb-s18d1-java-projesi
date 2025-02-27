package com.example.s18d1jpa.dao;

import com.example.s18d1jpa.entity.BreadType;
import com.example.s18d1jpa.entity.Burger;
import com.example.s18d1jpa.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Create update ve delete işlemleri için EntityManagerı kullanacağız.
 * EntityManager türünde bir nesne oluşturmak ve bu nesneyi BurgerDaoImpl sınıfına enjekte etmek için @Autowired anotasyonu kullandık.
 * Bir işlem sınırı içinde işlem başarılıysa değişiklikler kalıcı hale gelir
 * ama hata oluşurssa @Transactional anotasyonu aracılığıyla değişiklikler geri alınır.(rollback)
 * findAll methodunda TypedQuery kullanmamızın nedeni tip güvenliği, performans ve optimizasyon,kod okunabilirliği ve hata ayıklamadan dolayıdır.
 * @Repository anotasyonu , işlemlerini veritabanıyla gerçekleştiren sınıfları işaretlemek için kullanılır.
 */

@Repository
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
        return burger;
    }
    @Transactional
    @Override
    public Burger update(Burger newburger) {
        return entityManager.merge(newburger);
    }

    @Override
    public Burger remove(int id) {
        Burger foundBurger = findById(id);
        entityManager.remove(foundBurger);
        return foundBurger;
    }

    @Override
    public List<Burger> findByPrice(int price) {
        TypedQuery<Burger> foundListQuery =
                entityManager.createQuery("SELECT b FROM Burger b where b.price > :price ORDER BY b.price desc", Burger.class);
        foundListQuery.setParameter("price", price);

        return foundListQuery.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query =
                entityManager.createQuery("SELECT b FROM Burger b where b.breadType = :breadType ORDER BY b.name desc", Burger.class);
        query.setParameter("breadType",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> foundAll = entityManager.createQuery("SELECT b from Burger b", Burger.class);
        return foundAll.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query =
                entityManager.createQuery("SELECT b FROM Burger b where b.contents like CONCAT('%', :content, '%') ORDER BY b.name", Burger.class);
                query.setParameter("content", content);
        return query.getResultList();
    }
}
