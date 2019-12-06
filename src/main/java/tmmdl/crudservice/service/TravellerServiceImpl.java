package tmmdl.crudservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tmmdl.crudservice.dao.TravellerDAO;
import tmmdl.crudservice.entity.Traveller;

import java.util.List;

@Service
public class TravellerServiceImpl implements TravellerService {

    TravellerDAO travellerDAO;

    @Autowired
    public TravellerServiceImpl(TravellerDAO travellerDAO){
        this.travellerDAO = travellerDAO;
    }

    @Override
    public List<Traveller> findSeeker(String destination) {
        return travellerDAO.findSeeker(destination);
    }

    @Override
    @Transactional
    public Traveller findById(int id) {
        return travellerDAO.findById(id);
    }

    @Override
    @Transactional
    public List<Traveller> findByDestination(String destination) {
        return travellerDAO.findByDestination(destination);
    }

    @Override
    @Transactional
    public void save(Traveller traveller) {
        travellerDAO.save(traveller);
    }

    @Override
    @Transactional
    public List<Traveller> findByDestAndByDate(String date, String destination){
        return travellerDAO.findByDestAndByDate(date, destination);
    }
}
