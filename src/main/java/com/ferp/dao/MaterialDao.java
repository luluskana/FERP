package com.ferp.dao;

import com.ferp.domain.LogHistory;
import com.ferp.domain.Material;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    public void delete(Long id) {

        Set<LogHistory> logHistories = findById(id).getLogHistories();

        Session session = ((Session) entityManager.getDelegate());
        SQLQuery query1 = session.createSQLQuery("DELETE FROM LOG_HISTORY  WHERE material = :materialId");
        query1.setParameter("materialId", id);
        query1.executeUpdate();
        SQLQuery query2 = session.createSQLQuery("DELETE FROM MATERIAL  WHERE id = :id");
        query2.setParameter("id", id);
        query2.executeUpdate();
    }

    public List<Material> findByMaterialStatus(String[] strings) {
        Criteria criteria = ((Session) entityManager.getDelegate()).createCriteria(Material.class);
        Criterion case1 = Restrictions.in("status", strings);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(case1);
        return criteria.list();
    }

    public List<Material> findAllMaterialGe(Date date) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Material> cq = builder.createQuery(Material.class);
        Root<Material> root = cq.from(Material.class);
        cq.where(
                builder.or(
                        builder.lessThanOrEqualTo(root.<Date>get("rohsAlertDateTest"), date),
                        builder.lessThanOrEqualTo(root.<Date>get("halogenAlertDateTest"), date)
                )
        );
        return entityManager.createQuery(cq).getResultList();
    }

    public List<Material> findAll() {
        return entityManager.createQuery("SELECT o FROM Material o order by createDate", Material.class).getResultList();
    }
}
