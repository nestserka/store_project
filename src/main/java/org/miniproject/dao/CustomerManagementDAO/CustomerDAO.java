package org.miniproject.dao.CustomerManagementDAO;


import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.CustomerManagement.Customer;

public class CustomerDAO extends GenericDao<Customer> {

    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
