package cz.cvut.ear.clubevidence.service;

import cz.cvut.ear.clubevidence.dao.CompetitionDao;
import cz.cvut.ear.clubevidence.dao.UserDao;
import cz.cvut.ear.clubevidence.exception.NotFoundException;
import cz.cvut.ear.clubevidence.model.Competition;
import cz.cvut.ear.clubevidence.model.User;
import cz.cvut.ear.clubevidence.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Service
public class CompetitionService {
    private final CompetitionDao competitionDao;
    private final UserDao userDao;


    @Autowired
    public CompetitionService(CompetitionDao competitionDao, UserDao userDao) {
        this.competitionDao = competitionDao;
        this.userDao = userDao;
    }


    @Transactional(readOnly = true)
    public List<Competition> getAllCompetitions() {
        return competitionDao.findAll();
    }


    @Transactional(readOnly = true)
    public Competition getCompetitionById(Integer id) {
        return competitionDao.find(id);
    }


    @Transactional
    public void createCompetition(Competition competition) {
        competitionDao.persist(competition);
    }


    @Transactional
    public void updateCompetition(Competition competition) {
        competitionDao.update(competition);
    }


    @Transactional
    public void deleteCompetition(Competition competition) {
        competitionDao.remove(competition);
    }

    @Transactional
    public void registerUserForCompetition(User member, Competition competition) {

        if (member == null) {
            throw new NotFoundException("User is not found.");
        }

        if (competition == null) {
            throw new NotFoundException("Competition is not found.");
        }

        if (competition.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().compareTo(LocalDateTime.now().toLocalDate()) < 0) {
            throw new NotFoundException("Competition is not found.");
        }
        competition.getParticipants().add(member);

        competitionDao.update(competition);
    }

    @Transactional
    public void persistCompetition(User admin, Competition competition) {
        Objects.requireNonNull(admin);
        Objects.requireNonNull(competition);
        if(admin.getRole() == Role.ADMIN) {
            competitionDao.persist(competition);
        }
    }


}
