package com.example.demo.service.export;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.example.demo.entity.Facture;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;

@Service
public class ExportPDFITextService {

    public void export(OutputStream os, FactureDTO facture) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, os);
        document.open();
        
        document.addTitle("Facture");
        document.add(new Paragraph (facture.getClient().getNom()));
        document.add(new Paragraph (facture.getClient().getPrenom()));
        document.add(new Paragraph ("factures"));
        
        for (LigneFactureDTO factu : facture.getLigneFactures() ) {
        	document.add(new Paragraph (factu.getDesignation()));
        	document.add(new Paragraph (factu.getQuantite()));
        }

        document.add(new Paragraph("Hello"));
        document.close();
    }
}
