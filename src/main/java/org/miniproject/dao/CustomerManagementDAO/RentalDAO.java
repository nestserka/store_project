package org.miniproject.dao.CustomerManagementDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.CustomerManagement.Rental;

public class RentalDAO extends GenericDao<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getAnyUnreturnedRental(){
        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.returnDate is null ", Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
