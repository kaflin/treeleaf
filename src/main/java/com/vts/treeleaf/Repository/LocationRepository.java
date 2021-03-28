package com.vts.treeleaf.Repository;

import com.vts.treeleaf.Dto.LocationDto;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    List<Location> findLocationByVehicle(Vehicle vehicle);

    @Query("select v from Location v where v.locationName=:name")
    Optional<Location> findByName(@Param("name")String locationName);



//    @Query("update Location l set l.locationName = :location")
//    Location update(@Param("location")Location location);
}
