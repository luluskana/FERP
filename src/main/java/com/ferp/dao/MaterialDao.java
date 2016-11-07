package com.ferp.dao;

import com.ferp.domain.LogHistory;
import com.ferp.domain.Material;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        deleteFile(logHistories);
    }

    public void deleteFile(Set<LogHistory> logHistories) {
        for(LogHistory logHistory : logHistories) {
            if(logHistory.getSpec() != null) {
                queryDelete(logHistory.getSpec());
            }
            if(logHistory.getRosh() != null) {
                queryDelete(logHistory.getRosh());
            }
            if(logHistory.getMsds() != null) {
                queryDelete(logHistory.getMsds());
            }
            if(logHistory.getHalogen() != null) {
                queryDelete(logHistory.getHalogen());
            }
            if(logHistory.getGuaranteeLetter() != null) {
                queryDelete(logHistory.getGuaranteeLetter());
            }
            if(logHistory.getRedPhosphorus() != null) {
                queryDelete(logHistory.getRedPhosphorus());
            }
        }
    }
    public void queryDelete(Long id) {
        String sqlSelect = "DELETE FROM ITEM_FILE WHERE ID = ?";
        jdbcTemplate.update(sqlSelect, id);
    }
}
