package com.vts.treeleaf.Mapper;

import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    @InheritInverseConfiguration
    @Mapping(target="location",ignore=true)
    @Mapping(target="camera",ignore=true)
    Vehicle mapDtoToVehicle(VehicleDto vehicleDto);


    VehicleDto mapVehicleToDto(Vehicle vehicle);


}
