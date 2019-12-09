package tmmdl.crudservice.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tmmdl.crudservice.entity.Traveller;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TravellerDAOImp implements TravellerDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(TravellerDAOImp.class);
    private EntityManager entityManager;

    @Autowired //constructor injection of entitymanager.
    public TravellerDAOImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<Traveller> findSeeker(String destination) {
        Session session = entityManager.unwrap(Session.class);
        Query<Traveller> query =
                session.createQuery("from Traveller where destination =: input AND seeker = true", Traveller.class);
        query.setParameter("input", destination);
        List<Traveller> travellers = query.getResultList();


        return travellers;
    }

    @Override
    public Traveller findById(int id) {

        Session session = entityManager.unwrap(Session.class);
        Traveller traveller = session.get(Traveller.class, id);

        return traveller;
    }

    @Override
    public List<Traveller> findByDestination(String destination) {

        Session session = entityManager.unwrap(Session.class);
        Query<Traveller> query =
                session.createQuery("from  Traveller where destination = :input AND seeker = false", Traveller.class);
        query.setParameter("input",  destination );
        List<Traveller> travellers = query.getResultList();

        return travellers;
    }

    @Override
    public List<Traveller> findByDestAndByDate(String date, String destination) {

        Session session = entityManager.unwrap(Session.class);
        Query<Traveller> query = session
                .createQuery("from Traveller where date =: inputDate AND destination =: inputDestination AND seeker = false", Traveller.class);
        query.setParameter("inputDate", date);
        query.setParameter("inputDestination", destination);
        List<Traveller> travellers = query.getResultList();

        return travellers;
    }

    @Override
    public void save(Traveller traveller) {

        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(traveller);
    }
}
