package com.vts.treeleaf.Controller;

import com.vts.treeleaf.Dto.LocationDto;
import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    //For saving loaction
    @PostMapping("/save")
    public ResponseEntity<Void> createLocation(@RequestBody LocationDto locationDto)
    {
        locationService.save(locationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //For getting All Location
    @GetMapping("/all")
    public ResponseEntity<List<LocationResponse>>getAllLocations()
    {
        return status(HttpStatus.OK).body(locationService.getAllLocations());
    }
    //For getting location By Vehicle
    @GetMapping("/locationByVehicle/{id}")
    public ResponseEntity<List<LocationResponse>> getLocationByVehicle(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocationByVehicle(id));
    }

    //For deleting
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //For update
    @PutMapping("/save")
    public ResponseEntity<Void> updateLocation(@RequestBody LocationDto locationDto)
    {
        locationService.save(locationDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
