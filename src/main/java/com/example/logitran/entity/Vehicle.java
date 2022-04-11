package com.example.logitran.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="vehicle")
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private int vehicleId;

    @Column(name = "vehicle_no")
    private String vehicleNo;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "capacity")
    private int capacity;

    @Column(name="driver_id")
    private int driverID;

    @Column(name="company_id")
    private int companyId;

    @JsonIgnore
    @Column(columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean isDelete;

    public Vehicle(String vehicleType, int capacity, int driverID) {
        this.vehicleType = vehicleType;
        this.capacity = capacity;
        this.driverID = driverID;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", capacity=" + capacity +
                ", driverID=" + driverID +
                '}';
    }
}
