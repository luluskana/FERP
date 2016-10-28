package com.ferp.dao;

import com.ferp.domain.AppUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by apichat on 10/26/2016 AD.
 */
@Repository
@Transactional
public class AppUserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(AppUser appUser) {
        entityManager.persist(appUser);
    }

    public AppUser findByUsername(String username) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(AppUser.class);
        c.add(Restrictions.eq("username", username));
        return (AppUser)c.uniqueResult();
    }

    public void update(AppUser appUser) {
        entityManager.merge(appUser);
        entityManager.flush();
    }

    public AppUser findById(Long id) {
        return entityManager.find(AppUser.class, id);
    }
}
