package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.Club;
import cz.cvut.ear.clubevidence.model.CompetitionRecord;
import cz.cvut.ear.clubevidence.service.CompetitionRecordService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/competition_records")
public class CompetitionRecordContoller {
    CompetitionRecordService competitionRecordService;
    public CompetitionRecordContoller(CompetitionRecordService competitionRecordService){
        this.competitionRecordService = competitionRecordService;
    }

    @GetMapping(value = "/allCompetitionRecords", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CompetitionRecord> findAllCompetitionRecords(){
        return competitionRecordService.findAll();
    }
    @GetMapping(value = "/competitionRecord/{competitionRecordId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompetitionRecord findCompetitionRecordById(@PathVariable Integer competitionRecordId) {
        return competitionRecordService.findById(competitionRecordId);
    }
}
