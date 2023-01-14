package com.nastyabeggin.lab4back.beans;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserBean {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        UserBean userBean = (UserBean) o;
        return username != null && Objects.equals(username, userBean.username);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
