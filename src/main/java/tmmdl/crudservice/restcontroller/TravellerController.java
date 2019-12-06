package tmmdl.crudservice.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tmmdl.crudservice.entity.Traveller;
import tmmdl.crudservice.service.TravellerService;

import java.util.List;

@RestController
@RequestMapping("/")
public class TravellerController {

    private TravellerService travellerService;

    public TravellerController(TravellerService travellerService){
        this.travellerService = travellerService;
    }

    //@GetMapping("/travellers/{id}")
    public Traveller getTraveller(@PathVariable int id){
        Traveller traveller = travellerService.findById(id);
        if (traveller == null){
            throw new RuntimeException("no traveller");
        }
        return traveller;
    }

    //@GetMapping("/travellers/{destinaiton}")
    @RequestMapping(value = "/travellers", params = {"destination"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Traveller> findByDestination(@RequestParam String destination){

        List<Traveller> list = travellerService.findByDestination(destination);
        return list;
    }

    @PostMapping("/travellers")
    public Traveller addTraveller(@RequestBody Traveller traveller){
        traveller.setId(0);
        travellerService.save(traveller);
        return traveller;
    }

    @RequestMapping(value = "/travellers", params = {"date", "destination"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Traveller> findByDestAndByDate(@RequestParam("date") String date, @RequestParam("destination") String destination){
        List<Traveller> list= travellerService.findByDestAndByDate(date, destination);
        return list;
    }

    @RequestMapping(value = "/seeker", params = {"destination"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Traveller> findBySeek(@RequestParam("destination") String destination) {
        List<Traveller> list = travellerService.findSeeker(destination);
        return list;
    }
}
