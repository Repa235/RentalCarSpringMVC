package com.example.rentalcarspringmvc.repository;


import com.example.rentalcarspringmvc.config.HibernateConfig;
import com.example.rentalcarspringmvc.entities.Prenotazione;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class PrenotazioneRepositoryImpl implements PrenotazioneRepository {
    public Prenotazione getPrenotazione(Long id) {
    try ( Session session = HibernateConfig.getSessionFactory().openSession()) {
        return session.get(Prenotazione.class, id);
    } catch (HibernateException e) {
        return null;
    }
}

    public List<Prenotazione> getAllPrenotazioni() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Prenotazione> cr = cb.createQuery(Prenotazione.class);
        Root<Prenotazione> root = cr.from(Prenotazione.class);
        Query<Prenotazione> query = session.createQuery(cr);
        List<Prenotazione> results = query.getResultList();
        return results;
    }

    public boolean saveOrUpdatePrenotazione(Prenotazione c) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(c); ;
            transaction.commit();
            result = true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return result;
    }

    public boolean deletePrenotazione(Prenotazione c) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.delete(c);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }
        return result;
    }

}

