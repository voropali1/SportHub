package cz.cvut.ear.clubevidence.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MembershipRecord")
public class MembershipRecord extends AbstractEntity {
    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private User member;
    @Basic(optional = false)
    @Column(nullable = false)
    private Date expireDate;
    @JsonIgnore
    @OneToOne
    private Payment payment;

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date hasMembershipTil) {
        this.expireDate = hasMembershipTil;
    }
}
