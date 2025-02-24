package cz.cvut.ear.clubevidence.service;

import cz.cvut.ear.clubevidence.dao.*;
import cz.cvut.ear.clubevidence.exception.*;
import cz.cvut.ear.clubevidence.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClubService {
    private final ClubDao clubDao;
    private final UserDao memberDao;
    private final TrainingDao trainingDao;
    private final CompetitionDao competitionDao;

    @Autowired
    public ClubService(ClubDao clubDao, UserDao memberDao, TrainingDao trainingDao, CompetitionDao competitionDao) {
        this.clubDao = clubDao;
        this.memberDao = memberDao;
        this.trainingDao = trainingDao;
        this.competitionDao = competitionDao;
    }

    @Transactional(readOnly = true)
    public Club findById(Integer id){
        Objects.requireNonNull(id);
        if(id<=0){
            throw new IllegalArgumentException("Invalid id. It must be a positive integer.");
        }
        Club club = clubDao.find(id);
        if(club==null){
            throw NotFoundException.create("Club", id);
        }
        return club;
    }

    @Transactional(readOnly = true)
    public List<Club> findAll(){
        return clubDao.findAll();
    }

    @Transactional
    public void addClub(String name, String address){
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
        final Club newClub = new Club();
        newClub.setName(name);
        newClub.setAddress(address);

        clubDao.persist(newClub);
    }
}
