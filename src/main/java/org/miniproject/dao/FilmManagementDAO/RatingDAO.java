package org.miniproject.dao.FilmManagementDAO;

import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.FilmManagement.Rating;

public class RatingDAO extends GenericDao<Rating> {

    public RatingDAO(SessionFactory sessionFactory) {
        super(Rating.class, sessionFactory);
    }

}
