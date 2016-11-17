package com.ferp.dao;

import com.ferp.domain.MaterialType;
import com.sun.prism.Material;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apichat on 11/2/2016 AD.
 */
@Repository
@Transactional
public class MaterialTypeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(MaterialType materialType) {
        entityManager.persist(materialType);
    }

    public void update(MaterialType materialType) {
        entityManager.merge(materialType);
        entityManager.flush();
    }

    public void delete(Long id) {
        entityManager.remove(findById(id));
    }

    public List<MaterialType> findAllMaterialType() {
        return entityManager.createQuery("SELECT o FROM MaterialType o order by createDate", MaterialType.class).getResultList();
    }

    public MaterialType findById(Long id) {
        return entityManager.find(MaterialType.class, id);
    }

}
