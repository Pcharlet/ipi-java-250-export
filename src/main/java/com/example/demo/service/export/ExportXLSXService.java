package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.lowagie.text.Row;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExportXLSXService {

    public void export(OutputStream os, List<ClientDTO> clients) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("clients");

        XSSFRow headerRow = sheet.createRow(0);
        XSSFRow headerRow1 = sheet.createRow(1);
        XSSFRow headerRow2 = sheet.createRow(2);
        
        XSSFCell cellNom = headerRow.createCell(0);
        XSSFCell cellPrenom = headerRow.createCell(1);
        
        XSSFCell cellnom1 = headerRow1.createCell(0);
        XSSFCell cellprenom1 = headerRow1.createCell(1);
        
        cellNom.setCellValue("Nom");
        cellPrenom.setCellValue("Prenom");
        
        StringBuilder str = new StringBuilder();
        
        for (ClientDTO client : clients ) {
        	cellnom1.setCellValue(client.getNom());
        	cellprenom1.setCellValue(client.getPrenom());
        }
        
        		
        workbook.write(os);
        workbook.close();
    }
}
