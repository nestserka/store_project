package org.miniproject.dao.CustomerManagementDAO;

import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.StoreManagement.Store;

public class StoreDAO extends GenericDao<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
