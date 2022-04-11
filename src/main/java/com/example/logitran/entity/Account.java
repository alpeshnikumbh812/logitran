package com.example.logitran.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter()
@Setter
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name="acc_id")
    private int accId;

    @Column(name="username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private int roleId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id",insertable = false,updatable = false)
    private Role role;

    @JsonIgnore
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isActive;

    public Account(String username, String password, int roleId) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                '}';
    }
}
