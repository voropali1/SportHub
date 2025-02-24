package cz.cvut.ear.clubevidence.service;

import cz.cvut.ear.clubevidence.dao.ClubDao;
import cz.cvut.ear.clubevidence.dao.TrainingDao;
import cz.cvut.ear.clubevidence.dao.UserDao;
import cz.cvut.ear.clubevidence.exception.ExceptionGeneral;
import cz.cvut.ear.clubevidence.exception.NotFoundException;
import cz.cvut.ear.clubevidence.model.Club;
import cz.cvut.ear.clubevidence.model.Training;
import cz.cvut.ear.clubevidence.model.User;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class TrainingService {
    private final TrainingDao trainingDao;
    private final UserDao userDao;
    private final ClubDao clubDao;
    @Autowired
    public TrainingService(TrainingDao trainingDao, UserDao userDao, ClubDao clubDao) {
        this.trainingDao = trainingDao;
        this.userDao = userDao;
        this.clubDao = clubDao;
    }
    @Transactional
    public void persist(Club club, Training training) {
        Objects.requireNonNull(training);
        Objects.requireNonNull(club);
        if (trainingDao.exists(training.getId())) {
            throw new IllegalIdentifierException("Training with id: " + training.getId() + " already exists");
        }
        if (clubDao.exists(club.getId())) {
            training.setClub(club);
            trainingDao.persist(training);
        } else {
            throw new NotFoundException("Club not found");
        }
    }

    @Transactional(readOnly = true)
    public List<Training> findAll() {
        return trainingDao.findAll();
    }

    @Transactional(readOnly = true)
    public Training find(Integer id) {
        Objects.requireNonNull(id);
        if(!trainingDao.exists(id)){
            throw new NotFoundException("Training not found");
        }
        return trainingDao.find(id);
    }

    @Transactional(readOnly = true)
    public List<Training> findAllAvailable(){
        return trainingDao.findAllAvailable();
    }


    @Transactional
    public void update(Training training) {
        Objects.requireNonNull(training);
        if(!trainingDao.exists(training.getId())){
            throw new NotFoundException("Training not found");
        }
        trainingDao.update(training);
    }

    @Transactional
    public void addTrainingToClub(Integer clubId, Training training){
        Objects.requireNonNull(clubId);
        Objects.requireNonNull(training);

        Club club = clubDao.find(clubId);

        if (club != null) {
            training.setClub(club);
            trainingDao.persist(training);
        } else {
            throw new NotFoundException("Club not found");
        }
    }

    @Transactional
    public void remove(Training training) {
        Objects.requireNonNull(training);
        if(!trainingDao.exists(training.getId())){
            throw new NotFoundException("Training not found");
        }
        trainingDao.remove(training);
    }


    @Transactional
    public void registerUserForTraining(User member, Training training) {
        Objects.requireNonNull(training);
        Objects.requireNonNull(member);
        if(!userDao.exists(member.getId())){
            throw new NotFoundException("User not found");
        }

        if(!trainingDao.exists(training.getId())){
            throw new NotFoundException("Training not found");
        }

        if (training.getMembers().size() > 20) {
            throw new ExceptionGeneral("Number of participants may not exceed 20");
        }
        training.getMembers().add(member);

        trainingDao.update(training);
    }

    @Transactional
    public void unsubscribeFromTraining(User member, Training training) {
        Objects.requireNonNull(training);
        Objects.requireNonNull(member);
        if(!userDao.exists(member.getId())){
            throw new NotFoundException("User not found");
        }

        if(!trainingDao.exists(training.getId())){
            throw new NotFoundException("Competition not found");
        }

        training.getMembers().remove(member);

        trainingDao.update(training);
    }

}
