package cz.cvut.ear.clubevidence.service;

import cz.cvut.ear.clubevidence.dao.CompetitionRecordDao;
import cz.cvut.ear.clubevidence.exception.ExceptionGeneral;
import cz.cvut.ear.clubevidence.exception.NotFoundException;
import cz.cvut.ear.clubevidence.model.CompetitionRecord;
import cz.cvut.ear.clubevidence.model.User;
import cz.cvut.ear.clubevidence.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CompetitionRecordService {
    private final CompetitionRecordDao competitionRecordDao;


    @Autowired
    public CompetitionRecordService(CompetitionRecordDao competitionRecordDao) {
        this.competitionRecordDao = competitionRecordDao;
    }


    @Transactional(readOnly = true)
    public List<CompetitionRecord> findAll() {
        return competitionRecordDao.findAll();
    }


    @Transactional(readOnly = true)
    public CompetitionRecord findById(Integer id) {
        Objects.requireNonNull(id);
        if(id<=0){
            throw new IllegalArgumentException("Invalid id. It must be a positive integer.");
        }
        if(!competitionRecordDao.exists(id)){
            throw new NotFoundException("Competition record not found");
        }
        return competitionRecordDao.find(id);
    }

    @Transactional
    public void persistCompetitionRecord(CompetitionRecord competitionRecord) {
        Objects.requireNonNull(competitionRecord);
        if(competitionRecordDao.exists(competitionRecord.getId())){
            throw new ExceptionGeneral("Competition record already exists");
        }
        competitionRecordDao.persist(competitionRecord);
    }


    @Transactional
    public void updateCompetitionRecord(CompetitionRecord competitionRecord) {
        Objects.requireNonNull(competitionRecord);
        if(!competitionRecordDao.exists(competitionRecord.getId())){
            throw new NotFoundException("Competition record not found");
        }
        competitionRecordDao.update(competitionRecord);
    }


    @Transactional
    public void deleteCompetitionRecord(CompetitionRecord competitionRecord) {
        Objects.requireNonNull(competitionRecord);
        if(!competitionRecordDao.exists(competitionRecord.getId())){
            throw new NotFoundException("Competition record not found");
        }
        competitionRecordDao.remove(competitionRecord);
    }
}
