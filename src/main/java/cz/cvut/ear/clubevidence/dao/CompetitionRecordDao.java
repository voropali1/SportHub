package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.CompetitionRecord;
import org.springframework.stereotype.Repository;

@Repository
public class CompetitionRecordDao extends BaseDao<CompetitionRecord> {
    public CompetitionRecordDao(){
        super(CompetitionRecord.class);
    }

}
