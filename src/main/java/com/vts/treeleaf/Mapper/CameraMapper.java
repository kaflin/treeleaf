package com.vts.treeleaf.Mapper;

import com.vts.treeleaf.Dto.CameraDto;
import com.vts.treeleaf.Dto.LocationDto;
import com.vts.treeleaf.Dto.LocationResponse;
import com.vts.treeleaf.Model.Camera;
import com.vts.treeleaf.Model.Location;
import com.vts.treeleaf.Model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel="spring")
public interface CameraMapper {

    @Mapping(target="id",source="cameraDto.id")
    @Mapping(target="cameraName",source="cameraDto.cameraName")
    @Mapping(target="vehicle",source="vehicle")
    @Mapping(target="location",source="location")
    Camera map(CameraDto cameraDto, Vehicle vehicle,Location location);

    @Mapping(target="id",source="camera.id")
    @Mapping(target="cameraName",source="camera.cameraName")
    @Mapping(target="vehicleName",source="camera.vehicle.vehicleName")
    CameraDto mapToDto(Camera camera);
}
