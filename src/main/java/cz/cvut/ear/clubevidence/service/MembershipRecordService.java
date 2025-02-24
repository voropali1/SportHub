package cz.cvut.ear.clubevidence.service;

import cz.cvut.ear.clubevidence.dao.MembershipRecordDao;
import cz.cvut.ear.clubevidence.model.MembershipRecord;
import cz.cvut.ear.clubevidence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MembershipRecordService {
    private final MembershipRecordDao membershipRecordDao;

    /**
     * Instantiates a new City service.
     *
     //* @param competitionDao the city dao
     */
    @Autowired
    public MembershipRecordService(MembershipRecordDao membershipRecordDao) {
        this.membershipRecordDao = membershipRecordDao;
    }

    /**
     * Find all page.
     *
     // * @param pageable the pageable
     // * @param name     the name
     * @return the page
     */
    @Transactional(readOnly = true)
    public List<MembershipRecord> findAll() {
        return membershipRecordDao.findAll();
    }


    @Transactional(readOnly = true)
    public MembershipRecord findById(Integer id) {
        return membershipRecordDao.find(id);
    }


    @Transactional
    public void persist(MembershipRecord membershipRecord) {
        membershipRecordDao.persist(membershipRecord);
    }


    @Transactional
    public void update(MembershipRecord membershipRecord) {
        membershipRecordDao.update(membershipRecord);
    }


    @Transactional
    public void remove(MembershipRecord membershipRecord) {
        membershipRecordDao.remove(membershipRecord);
    }

    @Transactional
    public boolean isMemberExpired(User user) {
        MembershipRecord membershipRecord = getMembershipRecordByUser(user);
        if (membershipRecord == null) {
            return false;
        }

        return membershipRecord.getExpireDate().before(new Date());
    }
    @Transactional
    public MembershipRecord getMembershipRecordByUser(User user) {
        return membershipRecordDao.find(user.getId());
    }

    @Transactional
    public void extendMembership(User user, Date newExpireDate) {
        MembershipRecord membershipRecord = getMembershipRecordByUser(user);
        membershipRecord.setExpireDate(newExpireDate);
        membershipRecordDao.update(membershipRecord);
    }

}
