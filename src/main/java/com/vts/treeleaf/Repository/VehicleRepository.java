package com.vts.treeleaf.Repository;

import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {


    @Query("select v from Vehicle v where v.vehicleName=:name")
    Optional<Vehicle> findByName(@Param("name")String vehicleName);


}
