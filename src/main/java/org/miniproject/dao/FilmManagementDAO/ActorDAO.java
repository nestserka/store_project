package org.miniproject.dao.FilmManagementDAO;

import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.FilmManagement.Actor;

public class ActorDAO extends GenericDao<Actor> {


    public ActorDAO(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
