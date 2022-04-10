package com.example.logitran.daoimpl;

import com.example.logitran.dao.VehicleDAO;
import com.example.logitran.entity.Driver;
import com.example.logitran.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Vehicle> getVehicles() {
        Session session = entityManager.unwrap(Session.class);

        Query<Vehicle> query = session.createQuery("from Vehicle where is_delete=0",Vehicle.class);
        List<Vehicle> vehicles = query.getResultList();
        return vehicles;
    }

    @Override
    public Vehicle getVehicle(int vehicleId) {

        Session session = entityManager.unwrap(Session.class);

        Vehicle vehicle = session.get(Vehicle.class,vehicleId);

        if(vehicle.isDelete)
            return null;

        return vehicle;
    }

    @Override
    public Vehicle saveOrUpadateVehicle(Vehicle vehicle) {
        Session session = entityManager.unwrap(Session.class);

        if(vehicle.getVehicleId()==0){
            session.save(vehicle);
        }
        else{
            try {
                session.update(vehicle);
            }
            catch (Exception e){

                throw new RuntimeException("No data exceed to update");
            }

        }

        return vehicle;
    }

    @Override
    public String deleteVehicle(int vehicleId) {
        Session session = entityManager.unwrap(Session.class);

        Vehicle vehicle = session.get(Vehicle.class,vehicleId);
        vehicle.setDelete(true);
        session.update(vehicle);
        return "Successfully deleted";
    }

    @Override
    public void deleteByDriverId(int driverId) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("update Vehicle set is_delete=1 where driver_id=:driverId");

        query.setParameter("driverId",driverId);
        query.executeUpdate();
    }

    @Override
    public void deleteVehicleOfDeletedDrivers(int companyId) {

        Session session = entityManager.unwrap(Session.class);

        Query query =  session.createQuery("UPDATE Vehicle set is_delete=1 " +
                " where company_id=:companyId");

        query.setParameter("companyId",companyId);
        query.executeUpdate();
    }

    @Override
    public List<Vehicle> findVehicleByCompanyId(int companyId) {

        Session session = entityManager.unwrap(Session.class);
        Query<Vehicle> query = session.createQuery("from Vehicle where company_id=:companyId and is_delete=0");

        query.setParameter("companyId",companyId);
        List<Vehicle> vehicleByCompanyId = query.getResultList();

        return vehicleByCompanyId;
    }
}
