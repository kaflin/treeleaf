package com.vts.treeleaf.Repository;

import com.vts.treeleaf.Model.Camera;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Long> {

    List<Camera> findCameraByVehicle(Vehicle vehicle);

}
