package com.ferp.dao;

import com.ferp.domain.SapCode;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by apichat on 11/15/2016 AD.
 */
@Repository
@Transactional
public class SapCodeDao {

    @PersistenceContext
    private EntityManager entityManager;

    public SapCode getNewSapCode() {
        SapCode sapCode = new SapCode();
        Session session = (Session) entityManager.getDelegate();
        String sqlSelect = "SELECT ID FROM SAP_CODE ORDER BY ID DESC LIMIT 1";
        List lists = session.createSQLQuery(sqlSelect).list();
        if(lists.size() <= 0) {
            sapCode.setId(1L);
        } else {
            Long id = ((BigInteger)lists.get(0)).longValue() + 1;
            sapCode.setId(id);
        }
        return sapCode;
    }

    public SapCode findByName(String name) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(SapCode.class);
        c.add(Restrictions.eq("name", name));
        return (SapCode)c.uniqueResult();
    }

    public SapCode findById(Long id) {
        return entityManager.find(SapCode.class, id);
    }

    public void delete(Long id) {
        Session session = ((Session) entityManager.getDelegate());
        SQLQuery query1 = session.createSQLQuery("DELETE FROM SAP_CODE  WHERE ID = :id");
        query1.setParameter("id", id);
        query1.executeUpdate();
    }
}
