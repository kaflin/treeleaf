package com.vts.treeleaf.PDF;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.vts.treeleaf.Model.Camera;
import com.vts.treeleaf.Model.Vehicle;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;


public class VehiclePDFExporter {

    private List<Camera> cameraList;

    public VehiclePDFExporter(List<Camera> cameraList) {
        this.cameraList= cameraList;
    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(4);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Vehicle ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Vehicle Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Location Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Camera Name", font));
        table.addCell(cell);
    }
    private void writeTableData(PdfPTable table) {
        for (Camera camera : cameraList) {
            table.addCell(String.valueOf(camera.getVehicle().getId()));
            table.addCell(camera.getVehicle().getVehicleName());
            table.addCell(camera.getLocation().getLocationName());
            table.addCell(camera.getCameraName());

        }
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Vehicles", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }


}
