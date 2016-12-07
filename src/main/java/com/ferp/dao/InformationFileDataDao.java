package com.ferp.dao;

import com.ferp.domain.InformationFileData;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by apichat on 11/24/2016 AD.
 */
@Repository
@Transactional
public class InformationFileDataDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(InformationFileData informationFileData) {
        Session session = (Session) entityManager.getDelegate();
        String sqlSelect = "SELECT ID FROM InformationFileData ORDER BY ID DESC LIMIT 1";
        List lists = session.createSQLQuery(sqlSelect).list();
        if(lists.size() <= 0) {
            informationFileData.setId(1L);
        } else {
            Long id = ((BigInteger)lists.get(0)).longValue() + 1;
            informationFileData.setId(id);
        }
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
