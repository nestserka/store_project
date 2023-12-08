package org.miniproject.dao.CustomerManagementDAO;

import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.StoreManagement.Country;

public class CountryDAO  extends GenericDao<Country> {


    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
