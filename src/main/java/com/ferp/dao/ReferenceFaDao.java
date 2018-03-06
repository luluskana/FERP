package com.ferp.dao;

import com.ferp.domain.LogHistory;
import com.ferp.domain.ReferenceFa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by apichat on 12/7/2016 AD.
 */
@Repository
@Transactional
public class ReferenceFaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ReferenceFa getReferenceFa() {
        ReferenceFa referenceFa = new ReferenceFa();
        Session session = (Session) entityManager.getDelegate();
        String sqlSelect = "SELECT ID FROM REFERENCE_FA ORDER BY ID DESC LIMIT 1";
        List lists = session.createSQLQuery(sqlSelect).list();
        if(lists.size() <= 0) {
            referenceFa.setId(1L);
        } else {
            Long id = ((BigInteger)lists.get(0)).longValue() + 1;
            referenceFa.setId(id);
        }
        return referenceFa;
    }

}
