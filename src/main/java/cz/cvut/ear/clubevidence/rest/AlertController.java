package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.Alert;
import cz.cvut.ear.clubevidence.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/alerts")
public class AlertController {
    AlertService alertService;
    @Autowired
    public AlertController(AlertService alertService){
        this.alertService = alertService;
    }

//    @GetMapping
//    public List<Alert> getAllPersonsAllerts(Integer id){
//        return alertService.getAllPersonsAllerts(id);
//    }
}
