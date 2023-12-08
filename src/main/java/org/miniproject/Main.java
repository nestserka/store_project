package org.miniproject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.miniproject.dao.CustomerManagementDAO.*;
import org.miniproject.dao.FilmManagementDAO.*;
import org.miniproject.dao.StoreManagementDAO.CityDAO;
import org.miniproject.dao.StoreManagementDAO.InventoryDAO;
import org.miniproject.dao.StoreManagementDAO.PaymentDAO;
import org.miniproject.domain.CustomerManagement.Customer;
import org.miniproject.domain.CustomerManagement.Payment;
import org.miniproject.domain.CustomerManagement.Rental;
import org.miniproject.domain.FilmManagement.*;
import org.miniproject.domain.StoreManagement.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private final SessionFactory sessionFactory;
    private final ActorDAO actorDAO;
    private final CustomerDAO customerDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final AddressDAO addressDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final InventoryDAO inventoryDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;
    private final CategoryDAO categoryDAO;
    private final FeatureDAO featureDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final LanguageDAO languageDAO;
    private final RatingDAO ratingDAO;

    public Main() {

        sessionFactory = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Feature.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Rating.class)
                .buildSessionFactory();

        actorDAO = new ActorDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        featureDAO = new FeatureDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        ratingDAO = new RatingDAO(sessionFactory);
    }


    public static void main(String[] args) {
        Main main = new Main();
        Customer customer = main.createCustomer();
        main.customerReturnInventoryToStore();
        main.customerRentInventory(customer);
        main.newFilmWasMade();
    }


    private void newFilmWasMade(){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Language language = languageDAO.getItems(0,20).stream().unordered().findAny().get();
            List<Category> categories =  categoryDAO.getItems(0,5);
            List<Actor> actors = actorDAO.getItems(0, 20);

            Film film = new Film();
            film.setActors(new HashSet<>(actors));
            film.setRating(Rating.PG13);
            film.setSpecialFeatures(Set.of(Feature.Trailers, Feature.Behind_the_Scenes));
            film.setLength((short)90);
            film.setReplacementCost(BigDecimal.TEN);
            film.setRentalRate(BigDecimal.ZERO);
            film.setLanguage(language);
            film.setDescription("Nice movie");
            film.setTitle("JR in Magic world");
            film.setRentalDuration((byte)30);
            film.setOriginalLanguage(language);
            film.setCategories(new HashSet<>(categories));
            film.setYear(Year.now());
            filmDAO.save(film);


            FilmText filmText = new FilmText();
            filmText.setId(film.getId());
            filmText.setFilm(film);
            filmText.setDescription(film.getDescription());
            filmText.setTitle(film.getTitle());
            filmTextDAO.save(filmText);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void customerRentInventory(Customer customer){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Film film = filmDAO.getFirstAvailableFilmForRent();
            Store store = storeDAO.getItems(0, 1).get(0);

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setRental(rental);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setCustomer(customer);
            payment.setAmount(BigDecimal.valueOf(55.77));
            payment.setStaff(staff);
            paymentDAO.save(payment);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void customerReturnInventoryToStore() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Rental rental = rentalDAO.getAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());
            rentalDAO.save(rental);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Customer createCustomer(){
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Store store = storeDAO.getItems(0, 2).get(0);
            City city = cityDAO.getByName("Vancouver");
            Address address = new Address();
            address.setAddress("757, Anchor Way RR2");
            address.setPhone("82-855-58-52");
            address.setCity(city);
            address.setDistrict("Pender Island");
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setActive(true);
            customer.setEmail("bob@gmail.com");
            customer.setAddress(address);
            customer.setStore(store);
            customer.setFirstName("Bob");
            customer.setLastName("Srown");
            customerDAO.save(customer);

            session.getTransaction().commit();
            return customer;
        }
        catch (RuntimeException e) {
            Session session = sessionFactory.getCurrentSession();
            session.getTransaction().rollback();
        }
        return null;
    }
}



