package cz.cvut.ear.clubevidence.service;

import cz.cvut.ear.clubevidence.dao.AlertDao;
import cz.cvut.ear.clubevidence.model.Alert;
import cz.cvut.ear.clubevidence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class AlertService {
    private final AlertDao alertDao;

    @Autowired
    public AlertService(AlertDao alertDao) {
        this.alertDao = alertDao;
    }

    @Transactional
    public void persistAlert(User reciever, String topic, String message){
        Objects.requireNonNull(reciever);
        Objects.requireNonNull(topic);
        Objects.requireNonNull(message);
        final Alert alert = new Alert();
        alert.setReciever(reciever);
        alert.setTopic(topic);
        alert.setMessage(message);
        alertDao.persist(alert);
    }

    @Transactional
    public void sendSuccessfulPaymentAlert(User reciever, String message){
        Objects.requireNonNull(reciever);
        Objects.requireNonNull(message);
        persistAlert(reciever, "Successful Payment", message);
    }
}
