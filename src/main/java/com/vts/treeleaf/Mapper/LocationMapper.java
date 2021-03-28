package com.vts.treeleaf.Mapper;

import com.vts.treeleaf.Dto.LocationDto;
import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Dto.VehicleDto;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target="id",source="locationDto.id")
   @Mapping(target="locationName",source="locationDto.locationName")
   @Mapping(target="vehicle",source="vehicle")
   Location map(LocationDto locationDto, Vehicle vehicle);

    @Mapping(target="id",source="location.id")
    @Mapping(target="locationName",source="location.locationName")
    @Mapping(target="vehicleName",source="location.vehicle.vehicleName")
    LocationResponse mapToDto(Location location);
//
//    @InheritInverseConfiguration
////    @Mapping(target="locationName",ignore=true)
//    @Mapping(target="vehicle",ignore=true)
//    Location mapDtoToLocation(LocationDto locationDto);
}
