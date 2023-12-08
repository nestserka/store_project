package org.miniproject.dao.CustomerManagementDAO;

import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.CustomerManagement.Rental;
import org.miniproject.domain.StoreManagement.Address;

public class AddressDAO extends GenericDao<Address> {
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
