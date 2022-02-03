package com.example.userapirest.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "to_phone")
public class Phone {
    private Long phone_id;
    private Long number;
    private Long cityCode;
    private Long contryCode;
    private User user;
    private Long user_id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PHONE_ID")
    public Long getPhone_id() {
        return phone_id;
    }
    public void setPhone_id(Long phone_id) {
        this.phone_id = phone_id;
    }

    @Column(name = "NUMBER")
    public Long getNumber() {return number;}
    public void setNumber(Long number) {this.number = number;}

    @Column(name = "CITY_CODE")
    public Long getCityCode() {
        return cityCode;
    }
    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    @Column(name = "COUNTRY_CODE")
    public Long getContryCode() {return contryCode;}
    public void setContryCode(Long contryCode) {this.contryCode = contryCode;}

    @ManyToOne
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    @Column(name = "USER_ID")
    public Long getUser_id() {return user_id;}
    public void setUser_id(Long user_id) {this.user_id = user_id;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(phone_id, phone.phone_id) &&
                Objects.equals(number, phone.number) &&
                Objects.equals(cityCode, phone.cityCode) &&
                Objects.equals(contryCode, phone.contryCode) &&
                Objects.equals(user_id, phone.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone_id, number, cityCode, contryCode, user_id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("phone_id=").append(phone_id);
        sb.append(", number=").append(number);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", contryCode=").append(contryCode);
        sb.append(", user_id=").append(user_id);
        sb.append('}');
        return sb.toString();
    }
}
