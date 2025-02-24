package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.Competition;
import cz.cvut.ear.clubevidence.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/competitions")
public class CompetitionController {
    CompetitionService competitionService;
    @Autowired
    public CompetitionController(CompetitionService competitionService){
        this.competitionService = competitionService;
    }

    @GetMapping("/competition/{id}")
    public Competition findCompetition(@PathVariable Integer id){
        return competitionService.getCompetitionById(id);
    }

    @GetMapping("/allCompetitions")
    public List<Competition> findAll(){
        return competitionService.getAllCompetitions();
    }
}
