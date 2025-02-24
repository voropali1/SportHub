package cz.cvut.ear.clubevidence.model;

import cz.cvut.ear.clubevidence.model.enums.Role;
import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
@NamedQueries({
        @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),})
public class User extends AbstractEntity{
    //@Basic(optional = false)
    @Column(name="firstname",nullable = false)
    private String firstname;
    @Basic(optional = false)
    @Column(name="surname",nullable = false)
    private String surname;
    @Basic(optional = false)
    @Column(name="address",nullable = false)
    private String address;
    @Basic(optional = false)
    @Column(name="phone",nullable = false)
    private String phone;
    @Basic(optional = false)
    @Column(name="username",nullable = false, unique = true)
    private String username;
    @Basic(optional = false)
    @Column(name="password",nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;
    public User() {
    }

    public User(String firstname, String surname, String address, String phone, String username, String password) {
        this.firstname=firstname;
        this.surname=surname;
        this.address=address;
        this.phone=phone;
        this.username=username;
        this.password=password;
    }

    public User(String firstname, String surname, String address, String phone, String username, String password, Role role) {
        this.firstname=firstname;
        this.surname=surname;
        this.address=address;
        this.phone=phone;
        this.username=username;
        this.password=password;
        this.role=role;
    }

    public void updateUserInfo(User updatedUser) {
        if (updatedUser.getFirstName() != null) {
            this.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getSurname() != null) {
            this.setSurname(updatedUser.getSurname());
        }
        if (updatedUser.getAddress() != null) {
            this.setAddress(updatedUser.getAddress());
        }
        if (updatedUser.getPhone() != null) {
            this.setPhone(updatedUser.getPhone());
        }
        if (updatedUser.getUsername() != null) {
            this.setUsername(updatedUser.getUsername());
        }
        if (updatedUser.getRole() != null) {
            this.setRole(updatedUser.getRole());
        }
        if (updatedUser.getPassword() != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(updatedUser.getPassword());
            this.setPassword(hashedPassword);
        }
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }

    public void erasePassword() {
        this.password = null;
    }

    public Role getRole() {
        return role;
    }

    public boolean isAdmin() {
        return role == Role.ADMIN;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
