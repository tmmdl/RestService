package tmmdl.crudservice.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tmmdl.crudservice.dao.TravellerDAOImp;
import tmmdl.crudservice.entity.Traveller;
import tmmdl.crudservice.service.TravellerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    TravellerService travellerService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TravellerDAOImp.class);

    public Controller(TravellerService travellerService){
        this.travellerService = travellerService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model){

        model.addAttribute("welcome");

        return "welcome";
    }

    @PostMapping("/form")
    public String save(@ModelAttribute("traveller") Traveller traveller){

        travellerService.save(traveller);

        return "redirect:/welcome";
    }

    @GetMapping("/form")
    public String showForm(Model model){

        Traveller traveller = new Traveller();

        model.addAttribute("traveller", traveller);

        return "travellers/traveller-form";
    }

    @GetMapping("/list")
    public String listTravellers(Model model){

        model.addAttribute("traveller", new Traveller());

        return "travellers/sender-form";
    }

    @PostMapping("/list")
    public String show(Model model, @ModelAttribute Traveller traveller){

        String date = "";
        SimpleDateFormat  myFormat= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");

        List<Traveller> travellers = travellerService.findByDestination(traveller.getDestination());
        if (!traveller.getDate().isEmpty()) {
            travellers = travellerService.findByDestAndByDate(date, traveller.getDestination());
            try {
                date = myFormat.format(fromUser.parse(traveller.getDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (traveller.isSeeker()){
            travellers = travellerService.findSeeker(traveller.getDestination());
        }

        LOGGER.info("the date: " + date + " " + traveller.getDestination());

        LOGGER.info("size: " + travellers.size());

        model.addAttribute("travellers", travellers);

        return "travellers/list-of-travellers";
    }



    /*
    below methods to get a input
     */
    @GetMapping("/foo")
    public String showPage(Model model) {
        model.addAttribute("traveller", new Traveller()); //assume SomeBean has a property called datePlanted
        return "travellers/sender";
    }

    @PostMapping("/foo")
    public String showPage(@ModelAttribute("traveller") Traveller traveller) {

        LOGGER.info("date: " + traveller.getDate());

        //System.out.println("Date planted: " + traveller.getDate()); //in reality, you'd use a logger instead :)
        return "redirect:/welcome";
    }


}
