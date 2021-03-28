package com.vts.treeleaf.Service;

import com.vts.treeleaf.Dto.CameraDto;
import com.vts.treeleaf.Mapper.CameraMapper;
import com.vts.treeleaf.Model.Camera;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import com.vts.treeleaf.Repository.CameraRepository;
import com.vts.treeleaf.Repository.LocationRepository;
import com.vts.treeleaf.Repository.VehicleRepository;
import com.vts.treeleaf.exception.CameraNotFoundException;
import com.vts.treeleaf.exception.LocationNotFoundException;
import com.vts.treeleaf.exception.VehicleNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CameraService {

    private final CameraRepository cameraRepository;
    private final CameraMapper cameraMapper;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    @Transactional
    public void save(CameraDto cameraDto) {
        Vehicle vehicle=vehicleRepository.findByName(cameraDto.getVehicleName())
                .orElseThrow(()->new CameraNotFoundException(cameraDto.getVehicleName()));
        Location location =locationRepository.findByName(cameraDto.getLocationName())
                .orElseThrow(()->new LocationNotFoundException(cameraDto.getLocationName()));
        cameraRepository.save(cameraMapper.map(cameraDto,vehicle,location));
    }

    public List<CameraDto> getAllCameras() {
        return cameraRepository.findAll()
                .stream()
                .map(cameraMapper::mapToDto)
                .collect(toList());
    }

    public List<CameraDto> getCameraByVehicle(Long id) {
        Vehicle vehicle=vehicleRepository.findById(id)
                .orElseThrow(()->new VehicleNotFoundException(id.toString()));
        List<Camera> location=cameraRepository.findCameraByVehicle(vehicle);
        return location.stream().map(cameraMapper :: mapToDto).collect(Collectors.toList());
    }

    public void delete(Long id) {
        cameraRepository.deleteById(id);
    }

    public List<Camera> listAll() {
        return cameraRepository.findAll();
    }
}
