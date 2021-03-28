package com.vts.treeleaf.Service;

import com.vts.treeleaf.Dto.LocationDto;
import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Mapper.LocationMapper;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import com.vts.treeleaf.Repository.LocationRepository;
import com.vts.treeleaf.Repository.VehicleRepository;
import com.vts.treeleaf.exception.VehicleNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class LocationService {

    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Transactional
    public void save(LocationDto locationDto) {
        Vehicle vehicle=vehicleRepository.findByName(locationDto.getVehicleName())
           .orElseThrow(()->new VehicleNotFoundException(locationDto.getVehicleName()));
         locationRepository.save(locationMapper.map(locationDto,vehicle));
    }

    public List<LocationResponse> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::mapToDto)
                .collect(toList());
    }

    public List<LocationResponse>getLocationByVehicle(Long id) {
        Vehicle vehicle=vehicleRepository.findById(id)
                .orElseThrow(()->new VehicleNotFoundException(id.toString()));
        List<Location> location=locationRepository.findLocationByVehicle(vehicle);
        return location.stream().map(locationMapper :: mapToDto).collect(Collectors.toList());
    }

    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

//    public LocationDto update(LocationDto locationDto) {
//
//        Location location=locationRepository.update(locationMapper.mapDtoToLocation(locationDto));
//        locationDto.setId(location.getId());
//        return locationDto;
//
//    }
}
