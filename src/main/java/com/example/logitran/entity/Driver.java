package com.example.logitran.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="driver_id")
    private int driverId;

    @Column(name="name")
    private String name;

    @Column(name="contact_no")
    private String contactNo;

    @Column(name="email")
    private String email;

    @Column(name="company_id")
    private int companyId;

    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isAvailable;

    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isDelete;

    public Driver(String name, String contactNo, String email, int companyId) {
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
