package tmmdl.crudservice.dao;

import tmmdl.crudservice.entity.Traveller;

import java.util.List;

public interface TravellerDAO {

    //List<Traveller> findAll(); //change to arraylist?

    Traveller findById(int id);

    List<Traveller> findByDestination(String destination);

    List<Traveller> findByDestAndByDate(String date, String destination);

    void save(Traveller traveller);
}
