package com.vts.treeleaf.ServiceImpl;

import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Mapper.VehicleMapper;
import com.vts.treeleaf.Model.Vehicle;
import com.vts.treeleaf.Repository.VehicleRepository;
import com.vts.treeleaf.Service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;


    @Transactional
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
