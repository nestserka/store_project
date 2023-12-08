package org.miniproject.dao.StoreManagementDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.CustomerManagement.Rental;
import org.miniproject.domain.StoreManagement.City;

public class CityDAO extends GenericDao<City> {

    public CityDAO(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name){
        Query<City> query = getCurrentSession().createQuery("select c from City c where c.city = :NAME", City.class);
        query.setParameter("NAME", name);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
