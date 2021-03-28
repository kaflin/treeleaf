package com.vts.treeleaf.Service;

import com.vts.treeleaf.Dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto save(VehicleDto vehicleDto);

    List<VehicleDto> getAllVehicles();

    void delete(Long id);
}
