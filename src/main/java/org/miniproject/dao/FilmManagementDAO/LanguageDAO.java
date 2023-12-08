package org.miniproject.dao.FilmManagementDAO;


import org.hibernate.SessionFactory;
import org.miniproject.dao.GenericDao;
import org.miniproject.domain.FilmManagement.Language;

public class LanguageDAO extends GenericDao<Language> {
    public LanguageDAO( SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
