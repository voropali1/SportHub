package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.Club;
import cz.cvut.ear.clubevidence.model.Training;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainingDao extends BaseDao<Training>{
    public TrainingDao(){
        super(Training.class);
    }
    public List<Training> findAllAvailable(){
        return em.createNamedQuery("Training.findAllAvailable", Training.class).setParameter("status", "Avialable").getResultList();
    }

}
