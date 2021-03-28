package com.vts.treeleaf.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CameraDto {
    private Long id;
    private String cameraName;
    private String vehicleName;
    private String locationName;
}
