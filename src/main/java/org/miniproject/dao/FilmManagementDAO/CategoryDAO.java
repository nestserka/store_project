package org.miniproject.dao.FilmManagementDAO;

import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.FilmManagement.Category;


public class CategoryDAO extends GenericDao<Category> {
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
