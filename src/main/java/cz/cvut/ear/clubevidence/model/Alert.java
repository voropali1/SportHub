package cz.cvut.ear.clubevidence.model;

import jakarta.persistence.*;
@NamedQueries({
        @NamedQuery(
                name = "Alert.findPersonsAllAllerts",
                query = "SELECT al FROM Alert al WHERE al.reciever.id = :membersId"
        ),
        @NamedQuery(
                name = "Alert.findByTopic",
                query = "SELECT al FROM Alert al WHERE al.topic = :topic"
        )
})
@Entity
@Table(name = "Alert")
public class Alert extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "reciever_id", nullable = false)
    private User reciever;
    @Basic(optional = false)
    @Column(nullable = false)
    private String topic;
    @Basic(optional = false)
    @Column(nullable = false)
    private String message;

    public User getReciever() {
        return reciever;
    }

    public void setReciever(User reciever) {
        this.reciever = reciever;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
