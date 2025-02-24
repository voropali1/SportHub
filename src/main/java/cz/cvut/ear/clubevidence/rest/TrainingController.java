package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.Training;
import cz.cvut.ear.clubevidence.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/trainings")
public class TrainingController{
    TrainingService trainingService;
    @Autowired
    public TrainingController(TrainingService trainingService){
        this.trainingService = trainingService;

}
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Training> getTrainings(){
        return trainingService.findAll();
    }

}
