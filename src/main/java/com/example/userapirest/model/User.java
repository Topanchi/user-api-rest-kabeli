package com.example.userapirest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "to_users")
public class User {
    private Long user_id;
    private String name;
    private String email;
    private String password;
    private Date createdAt;
    private Date modifiedAt;
    private Boolean isActive;

    private List<Phone> phoneList = new ArrayList<>();

    public User() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @CreationTimestamp
    @Column(name = "MODIFIED_AT")
    public Date getModifiedAt() {
        return modifiedAt;
    }
    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Column(name = "IS_ACTIVE")
    public Boolean getIsActive() {return isActive;}
    public void setIsActive(Boolean active) {isActive = active;}


    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "USER_ID")
    public List<Phone> getPhoneList() {
        return phoneList;
    }
    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(user_id, user.user_id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(modifiedAt, user.modifiedAt) &&
                Objects.equals(isActive, user.isActive) &&
                Objects.equals(phoneList, user.phoneList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, name, email, password,
                createdAt, modifiedAt, isActive, phoneList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("user_id=").append(user_id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", isActive=").append(isActive);
        sb.append(", phoneList=").append(phoneList);
        sb.append('}');
        return sb.toString();
    }
}
