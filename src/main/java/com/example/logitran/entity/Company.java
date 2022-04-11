package com.example.logitran.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "name")
    private String name;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "address")
    private String address;

    @JsonIgnore
    @Column(name="acc_id")
    private int accId;

    @JsonIgnore
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isDelete;

    public Company(int companyId, String name, String email, String password, String contactNo, String address, boolean isInterState) {
        this.companyId = companyId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNo = contactNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
