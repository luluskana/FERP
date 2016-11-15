package com.ferp.dao;

import com.ferp.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by apichat on 11/15/2016 AD.
 */
@Repository
@Transactional
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> findAllCustomer() {
        return entityManager.createQuery("SELECT o FROM Customer o order by createDate", Customer.class).getResultList();
    }

    public Customer findByName(String name) {
        Criteria c = ((Session) entityManager.getDelegate()).createCriteria(Customer.class);
        c.add(Restrictions.eq("name", name));
        return (Customer)c.uniqueResult();
    }
}
