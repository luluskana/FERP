package com.ferp.dao;

import com.ferp.domain.LogHistory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by apichat on 12/7/2016 AD.
 */
@Repository
@Transactional
public class LogHistoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public LogHistory getNewLogHistory() {
        LogHistory logHistory = new LogHistory();
        Session session = (Session) entityManager.getDelegate();
        String sqlSelect = "SELECT ID FROM LOG_HISTORY ORDER BY ID DESC LIMIT 1";
        List lists = session.createSQLQuery(sqlSelect).list();
        if(lists.size() <= 0) {
            logHistory.setId(1L);
        } else {
            Long id = ((BigInteger)lists.get(0)).longValue() + 1;
            logHistory.setId(id);
        }
        return logHistory;
    }
}
