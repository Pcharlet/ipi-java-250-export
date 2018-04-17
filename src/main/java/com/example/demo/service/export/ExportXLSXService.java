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
        
        XSSFCell cellNom = headerRow.createCell(0);
        XSSFCell cellPrenom = headerRow.createCell(1);
        
        
        cellNom.setCellValue("Nom");
        cellPrenom.setCellValue("Prenom");
        
        int cpt=1;
        
        for (ClientDTO client : clients ) {
        	//création var
        	XSSFRow Row = sheet.createRow(cpt);
        	XSSFCell cellPrenom1 = Row.createCell(0);
        	XSSFCell cellNom1 = Row.createCell(1);
        	//set valeur
        	cellPrenom1.setCellValue(client.getPrenom().replaceAll(";", ""));
        	cellNom1.setCellValue(client.getNom().replaceAll(";", ""));
        	cpt++;
        }
        
        		
        workbook.write(os);
        workbook.close();
    }
}
