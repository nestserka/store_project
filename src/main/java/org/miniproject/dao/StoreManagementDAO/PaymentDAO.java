package org.miniproject.dao.StoreManagementDAO;


import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.CustomerManagement.Payment;

public class PaymentDAO extends GenericDao<Payment> {


    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}