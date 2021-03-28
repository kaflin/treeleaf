package com.vts.treeleaf.Controller;

import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Service.VehicleService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@AllArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    //For saving vehicle
    @PostMapping("/save")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto)
    {
      return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleDto));
    }
// For getting All Vehicle
    @GetMapping("/all")
    public ResponseEntity<List<VehicleDto>> getAllVehicles()
    {
        return ResponseEntity
                .status(HttpStatus.OK).body(vehicleService.getAllVehicles());
    }
//    For Updating Vehicle
    @PutMapping("/save")
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.save(vehicleDto));
    }

    //For deleting Vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
