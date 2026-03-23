/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorioescuelas;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;

/**
 *
 * @author Administrador
 */
public class ExportarPDF {
    
     public static void exportarJTable(JTable tabla) {

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar PDF");

        int seleccion = chooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            String ruta = chooser.getSelectedFile().getAbsolutePath();

            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(ruta));
                document.open();

                Paragraph titulo = new Paragraph("REPORTE DE ESCUELAS");
                titulo.setAlignment(Element.ALIGN_CENTER);
                document.add(titulo);
                document.add(new Paragraph(" "));

                TableModel modelo = tabla.getModel();
                PdfPTable pdfTable = new PdfPTable(modelo.getColumnCount());
                pdfTable.setWidthPercentage(100);

                // Encabezados
                for (int i = 0; i < modelo.getColumnCount(); i++) {
                    pdfTable.addCell(modelo.getColumnName(i));
                }

                // Datos
                for (int fila = 0; fila < modelo.getRowCount(); fila++) {
                    for (int col = 0; col < modelo.getColumnCount(); col++) {
                        Object valor = modelo.getValueAt(fila, col);
                        pdfTable.addCell(valor != null ? valor.toString() : "");
                    }
                }

                document.add(pdfTable);
                document.close();

                JOptionPane.showMessageDialog(null, "PDF creado correctamente:\n" + ruta);

            } catch (DocumentException | IOException e) {
                JOptionPane.showMessageDialog(null, "Error al crear PDF:\n" + e.getMessage());
            }
        }
    }
    
}
