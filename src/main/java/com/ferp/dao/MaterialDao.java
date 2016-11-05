package com.ferp.dao;

import com.ferp.domain.Material;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by apichat on 11/5/2016 AD.
 */
@Repository
@Transactional
public class MaterialDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void update(Material material) {
        entityManager.merge(material);
        entityManager.flush();
    }

    public Material findById(Long id) {
        return entityManager.find(Material.class, id);
    }

    public Material findByMaterialName(String materialName) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(Material.class);
        c.add(Restrictions.eq("materialName", materialName));
        return (Material)c.uniqueResult();
    }
}
