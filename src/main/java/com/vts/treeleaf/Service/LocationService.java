package com.vts.treeleaf.Service;

import com.vts.treeleaf.Dto.LocationDto;
import com.vts.treeleaf.Dto.LocationResponse;

import java.util.List;

public interface LocationService {
    void save(LocationDto locationDto);

    List<LocationResponse> getAllLocations();

    List<LocationResponse> getLocationByVehicle(Long id);

    void delete(Long id);
}
