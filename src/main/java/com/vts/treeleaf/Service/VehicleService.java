package com.vts.treeleaf.Service;

import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Mapper.VehicleMapper;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import com.vts.treeleaf.Repository.LocationRepository;
import com.vts.treeleaf.Repository.VehicleRepository;
import com.vts.treeleaf.exception.CameraAndVehicleNotFoundException;
import com.vts.treeleaf.exception.LocationNotFoundException;
import com.vts.treeleaf.exception.VehicleNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final LocationRepository locationRepository;

    public VehicleDto save(VehicleDto vehicleDto) {

        Vehicle vehicle = vehicleRepository.save(vehicleMapper.mapDtoToVehicle(vehicleDto));
        vehicleDto.setId(vehicle.getId());
        return vehicleDto;

    }

    @Transactional
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleMapper::mapVehicleToDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }



}
