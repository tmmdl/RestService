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

    public Controller(TravellerService travellerService){
        this.travellerService = travellerService;
    }

    @GetMapping("/welcome")
    public String welcome(Model model){

        model.addAttribute("welcome");

        return "welcome";
    }

    //save traveller
    @PostMapping("/traveller-form")
    public String saveTraveller(@ModelAttribute("traveller") Traveller traveller){

        String date = dateConverter(traveller.getDate());
        traveller.setSeeker(false);
        traveller.setDate(date);
        travellerService.save(traveller);

        return "redirect:/welcome";
    }

    @GetMapping("/traveller-form")
    public String showTravellerForm(Model model){

        Traveller traveller = new Traveller();
        model.addAttribute("traveller", traveller);

        return "travellers/traveller-form";
    }

    //save sender
    @PostMapping("/sender-form")
    public String saveSender(@ModelAttribute("sender") Traveller sender){

        String date = dateConverter(sender.getDate());
        sender.setSeeker(true);
        sender.setDate(date);
        travellerService.save(sender);
        return "redirect:/welcome";
    }

    @GetMapping("/sender-form")
    public String showSenderTraveller(Model model){

        Traveller sender = new Traveller();
        model.addAttribute("sender", sender);

        return "travellers/sender-form";
    }

    //list of travellers
    @GetMapping("/list-of-travellers")
    public String listTravellers(Model model){

        model.addAttribute("traveller", new Traveller());
        return "travellers/find-traveller";
    }

    @PostMapping("/list-of-travellers")
    public String show(Model model, @ModelAttribute Traveller traveller){

        List<Traveller> travellers = travellerService.findByDestination(traveller.getDestination());
        if (!traveller.getDate().isEmpty()) {
            travellers = travellerService.findByDestAndByDate(traveller.getDate(), traveller.getDestination());
        }
        model.addAttribute("travellers", travellers);

        return "travellers/list-of-travellers";
    }

    //list of senders
    @GetMapping("/list-of-senders")
    public String listSenders(Model model){

        model.addAttribute("sender", new Traveller());

        return "travellers/find-sender";
    }

    @PostMapping("/list-of-senders")
    public String showSender(Model model, @ModelAttribute Traveller sender){

        List<Traveller> senders = travellerService.findSeeker(sender.getDestination());
        model.addAttribute("senders", senders);

        return "travellers/list-of-senders";
    }

    private String dateConverter(String inputDate){

        String date = "";
        SimpleDateFormat  myFormat= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = myFormat.format(fromUser.parse(inputDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
