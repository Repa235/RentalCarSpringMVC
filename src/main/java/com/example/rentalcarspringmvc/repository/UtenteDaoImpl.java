package com.example.rentalcarspringmvc.repository;

import com.example.rentalcarspringmvc.config.HibernateConfig;
import com.example.rentalcarspringmvc.entities.Utente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class UtenteDaoImpl implements UtenteDao {
    @Override
    public Utente getUtente(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Utente.class, id);
        } catch (HibernateException e) {
            return null;
        }
    }

    @Override
    public boolean saveOrUpdateUtente(Utente c) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean result = false;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(c);
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

    @Override
    public boolean deleteUtente(Utente c) {
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

    @Override
    public List<Utente> getCustomers() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Utente> cr = cb.createQuery(Utente.class);
        Root<Utente> root = cr.from(Utente.class);
        cr.select(root).where(cb.equal(root.get("tipo"), "customer"));
        Query<Utente> query = session.createQuery(cr);
        List<Utente> results = query.getResultList();
        return results;
    }

    @Override
    public List<Utente> getUsersByUsername(String username) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Utente> cr = cb.createQuery(Utente.class);
        Root<Utente> root = cr.from(Utente.class);
        cr.select(root).where(cb.equal(root.get("username"), username));
        Query<Utente> query = session.createQuery(cr);
        List<Utente> results = query.getResultList();
        return  results;
    }

    @Override
    public List<Utente> getCustomerByParam(String filtro, String testo) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Utente> cr = cb.createQuery(Utente.class);
        Root<Utente> root = cr.from(Utente.class);
        Predicate filtername = cb.like(root.get(filtro), "%"+testo+"%");
        Predicate customer = cb.like(root.get("tipo"), "customer");
        Predicate andN = cb.and(filtername,customer);
        cr.select(root).where(andN);
        Query<Utente> query = session.createQuery(cr);
        List<Utente> results = query.getResultList();
        return  results;
    }
}
