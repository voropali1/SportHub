package cz.cvut.ear.clubevidence.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CompetitionRecord")
public class CompetitionRecord extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private User member;
    @ManyToOne
    @JoinColumn(name = "competition_id",nullable = false)
    private Competition competition;
    @Basic(optional = false)
    @Column(nullable = false)
    private int earnedPoints;
    @Basic(optional = false)
    @Column(nullable = false)
    private int Place;

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public int getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(int earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public int getPlace() {
        return Place;
    }

    public void setPlace(int place) {
        Place = place;
    }
}
