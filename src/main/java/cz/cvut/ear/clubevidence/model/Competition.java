package cz.cvut.ear.clubevidence.model;
import cz.cvut.ear.clubevidence.model.enums.Status;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Competition")
public class Competition extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private Date date;
    @Basic(optional = false)
    @Column(nullable = false)
    private String address;
    @Basic(optional = false)
    @Column(nullable = false)
    private int registeredParticipants;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @OrderBy("username")
    @JoinTable(name = "competition_participants")
    private List<User> participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRegisteredParticipants() {
        return registeredParticipants;
    }

    public void setRegisteredParticipants(int registeredParticipants) {
        this.registeredParticipants = registeredParticipants;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
