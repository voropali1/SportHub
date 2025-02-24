package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.MembershipRecord;
import org.springframework.stereotype.Repository;

@Repository
public class MembershipRecordDao extends BaseDao<MembershipRecord>{

    public MembershipRecordDao(){
        super(MembershipRecord.class);
    }
}
