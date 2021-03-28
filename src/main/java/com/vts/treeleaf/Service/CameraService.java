package com.vts.treeleaf.Service;

import com.vts.treeleaf.Dto.CameraDto;
import com.vts.treeleaf.Model.Camera;

import java.util.List;

public interface CameraService {
    void save(CameraDto cameraDto);

    List<CameraDto> getAllCameras();

    List<CameraDto> getCameraByVehicle(Long id);

    void delete(Long id);

    List<Camera> listAll();
}
