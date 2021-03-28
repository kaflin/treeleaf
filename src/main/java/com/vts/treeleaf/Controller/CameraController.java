package com.vts.treeleaf.Controller;
import com.lowagie.text.DocumentException;
import com.vts.treeleaf.Dto.CameraDto;
import com.vts.treeleaf.Model.Camera;
import com.vts.treeleaf.PDF.VehiclePDFExporter;
import com.vts.treeleaf.Service.CameraService;
import com.vts.treeleaf.ServiceImpl.CameraServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/camera")
@AllArgsConstructor
public class CameraController {
    private final CameraService cameraService;


    //For saving Camera
    @PostMapping("/save")
    public ResponseEntity<Void> createCamera(@RequestBody CameraDto cameraDto)
    {
        cameraService.save(cameraDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    //For getting All camera
    @GetMapping("/all")
    public ResponseEntity<List<CameraDto>>getAllCameras()
    {
        return status(HttpStatus.OK).body(cameraService.getAllCameras());
    }

    //For Getting camera By vehicle and id
    @GetMapping("/cameraByVehicle/{id}")
    public ResponseEntity<List<CameraDto>> getCameraByVehicle(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(cameraService.getCameraByVehicle(id));
    }

    //for Deleting Camera
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamera(@PathVariable Long id) {
        cameraService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //For Updating camera
    @PutMapping("/save")
    public ResponseEntity<Void> updateCamera(@RequestBody CameraDto cameraDto)
    {
        cameraService.save(cameraDto);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    //For Getting Pdf
    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Camera> cameraList = cameraService.listAll();

        VehiclePDFExporter exporter = new VehiclePDFExporter(cameraList);
        exporter.export(response);

    }

}
