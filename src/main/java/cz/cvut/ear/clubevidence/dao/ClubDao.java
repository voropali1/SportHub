package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubDao extends BaseDao<Club>{
    public ClubDao(){
        super(Club.class);
    }
}
