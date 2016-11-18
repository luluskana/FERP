package com.ferp.dao;

import com.ferp.domain.FaRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apichat on 11/17/2016 AD.
 */
@Repository
@Transactional
public class FaRequestDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(FaRequest faRequest) {
        entityManager.persist(faRequest);
    }

    public void update(FaRequest faRequest) {
        entityManager.merge(faRequest);
        entityManager.flush();
    }

    public FaRequest findByPartNumber(String partNumber) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        c.add(Restrictions.eq("partNo", partNumber));
        return (FaRequest)c.uniqueResult();
    }

    public List<FaRequest> findByStatus(String status) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        c.add(Restrictions.eq("status", status));
        return c.list();
    }
}
