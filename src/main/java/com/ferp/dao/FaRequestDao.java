package com.ferp.dao;

import com.ferp.domain.AppUser;
import com.ferp.domain.FaRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Date;
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
        Session session = (Session) entityManager.getDelegate();
        String sqlSelect = "SELECT ID FROM FaRequest ORDER BY ID DESC LIMIT 1";
        List lists = session.createSQLQuery(sqlSelect).list();
        if(lists.size() <= 0) {
            faRequest.setId(1L);
        } else {
            Long id = ((BigInteger)lists.get(0)).longValue() + 1;
            faRequest.setId(id);
        }
        entityManager.persist(faRequest);
    }

    public void update(FaRequest faRequest) {
        entityManager.merge(faRequest);
        entityManager.flush();
    }

    public FaRequest findById(Long id) {
        return entityManager.find(FaRequest.class, id);
    }

    public FaRequest findByPartNumber(String partNumber) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        c.add(Restrictions.eq("partNo", partNumber));
        return (FaRequest)c.uniqueResult();
    }

    public List<FaRequest> findByStatus(String[] status) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        c.add(Restrictions.in("status", status));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return c.list();
    }

    public List<FaRequest> findByCreateBy(AppUser appUser) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        c.add(Restrictions.eq("createBy", appUser));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return c.list();
    }

    public List<FaRequest> findByCreateByAndStatusIn(AppUser appUser,String[] status) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        Criterion case1 = Restrictions.in("status", status);
        Criterion case2 = Restrictions.eq("createBy", appUser);
        Criterion case3 = Restrictions.and(case1, case2);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        c.add(case3);
        return c.list();
    }

    public FaRequest findByIdAndCreateBy(Long id, AppUser appUser) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        Criterion case1 = Restrictions.eq("id", id);
        Criterion case2 = Restrictions.eq("createBy", appUser);
        Criterion case3 = Restrictions.and(case1, case2);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        c.add(case3);
        return (FaRequest)c.uniqueResult();
    }

    public List<FaRequest> findByStatusAndUser(String status, AppUser appUser) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        Criterion case1 = Restrictions.eq("status", status);
        Criterion case2 = Restrictions.eq("createBy", appUser);
        Criterion case3 = Restrictions.and(case1, case2);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        c.add(case3);
        return c.list();
    }

    public List<FaRequest> findByStatusAndUserSaleOut(String status, String name) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        Criterion case1 = Restrictions.eq("status", status);
        Criterion case2 = Restrictions.eq("saleOut", name);
        Criterion case3 = Restrictions.and(case1, case2);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        c.add(case3);
        return c.list();
    }

    public List<FaRequest> findAll() {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(FaRequest.class);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return c.list();
    }

    public List<FaRequest> findByStartDateAndEndDate(Date start, Date end) {
        Criteria c = ((Session)entityManager.getDelegate()).createCriteria(FaRequest.class);
        Criterion case1 = Restrictions.between("createDate", start, end);
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        c.add(Restrictions.and(case1));
        return c.list();
    }
}
