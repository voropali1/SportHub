package cz.cvut.ear.clubevidence.model;

import cz.cvut.ear.clubevidence.model.enums.Status;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Training.findAllAvailable",
                query = "SELECT tr FROM Training tr WHERE tr.status = 'Available'"
        )

})
@Entity
@Table(name = "Training")
public class Training extends AbstractEntity{
    @ManyToOne
    @OrderBy("name ASC")
    private Club club;
    @Basic(optional = false)
    @Column(nullable = false)
    private LocalTime time;
    @Basic(optional = false)
    @Column(nullable = false)
    private DayOfWeek dayOfWeek;
    @Basic(optional = false)
    @Column(nullable = false)
    private String type;
    @Basic(optional = false)
    @Column(nullable = false)
    private int registeredMembers;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
    @ManyToMany
    @OrderBy("username")
    @JoinTable(name = "training_member")
    private List<User> members;

    public Training(Club club, LocalTime time, DayOfWeek dayOfWeek, String type, Status status){
        this.club=club;
        this.time=time;
        this.dayOfWeek=dayOfWeek;
        this.type=type;
        this.status= Status.Available;
    }

    public Training() {

    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRegisteredMembers() {
        return registeredMembers;
    }

    public void setRegisteredMembers(int registeredMembers) {
        this.registeredMembers = registeredMembers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
