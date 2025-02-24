package cz.cvut.ear.clubevidence.dao;

import cz.cvut.ear.clubevidence.model.Alert;
import cz.cvut.ear.clubevidence.model.Training;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlertDao extends BaseDao<Alert>{
    public AlertDao(){
        super(Alert.class);
    }

    public List <Alert> findPersonsAllAllerts(Integer membersId){
        return em.createNamedQuery("Alert.findPersonsAllAllerts", Alert.class).setParameter("membersId", membersId).getResultList();
    }

    public List<Alert> findByTopic(String topicName){
        return em.createNamedQuery("Alert.findByTopic", Alert.class).setParameter("topic", topicName).getResultList();
    }
}
