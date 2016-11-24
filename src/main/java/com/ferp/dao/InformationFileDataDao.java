package com.ferp.dao;

import com.ferp.domain.InformationFileData;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by apichat on 11/24/2016 AD.
 */
@Repository
@Transactional
public class InformationFileDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(InformationFileData informationFileData) {
        entityManager.persist(informationFileData);
    }

    public InformationFileData findById(Long id) {
        return entityManager.find(InformationFileData.class, id);
    }

    public void update(InformationFileData informationFileData) {
        entityManager.merge(informationFileData);
        entityManager.flush();
    }
}
