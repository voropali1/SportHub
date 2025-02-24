package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.Competition;
import org.springframework.stereotype.Repository;

@Repository
public class CompetitionDao extends BaseDao<Competition>{
    public CompetitionDao(){
        super(Competition.class);
    }

}
