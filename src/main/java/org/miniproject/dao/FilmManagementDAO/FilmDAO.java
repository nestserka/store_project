package org.miniproject.dao.FilmManagementDAO;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.FilmManagement.Film;

public class FilmDAO extends GenericDao<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }


    public Film getFirstAvailableFilmForRent(){
        Query<Film> query = getCurrentSession().createQuery( "select f from Film f " +
                "where f.id not in (select distinct film.id from Inventory)", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
