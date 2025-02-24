package cz.cvut.ear.clubevidence.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Club")
public class Club extends AbstractEntity{
    @Basic(optional = false)
    @Column(nullable = false)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private String address;
    @ManyToMany
    @OrderBy("username")
    @JoinTable(name = "club_member")
    private List<User> members;

    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
   // @JoinColumn(name = "training_id", nullable = false)
    private List <Training> trainings;

    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
   // @JoinColumn(name = "competition_id")
    private List<Competition> competitions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @OneToMany
    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    @OneToMany
    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    @OneToMany
    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
    }
}
