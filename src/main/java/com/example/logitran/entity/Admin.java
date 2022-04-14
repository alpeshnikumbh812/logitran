package com.example.logitran.entity;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Admin(String username, String password) {
        this.email = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
