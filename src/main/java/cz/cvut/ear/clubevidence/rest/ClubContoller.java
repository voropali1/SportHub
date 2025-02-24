package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.Club;
import cz.cvut.ear.clubevidence.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/clubs")
public class ClubContoller {
    ClubService clubService;
    @Autowired
    public ClubContoller(ClubService clubService){
        this.clubService = clubService;
    }

    @GetMapping(value = "/allClubs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Club> getAllClubs(){
        return clubService.findAll();
    }
    @GetMapping(value = "/club/{clubId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Club getClubById(@PathVariable Integer clubId) {
        return clubService.findById(clubId);
    }
}
