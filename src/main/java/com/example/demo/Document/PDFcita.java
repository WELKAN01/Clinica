package com.example.demo.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.graph.Graph;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Citas;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfGraphics2D;
import com.lowagie.text.pdf.PdfLine;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PDFcita {
    public void export(Citas cita,HttpServletResponse response) throws DocumentException, IOException{
        Rectangle pagesize=new Rectangle(200f, 400f);
        Document documentopdf=new Document();
        documentopdf.setMargins(25f,10f,25f, 10f);
        documentopdf.setPageSize(pagesize);


        PdfWriter.getInstance(documentopdf, response.getOutputStream());
        documentopdf.open();
        //titulo, tipo de letra, tamaño de letra, posicion de esta
        Font fontittle=FontFactory.getFont(FontFactory.HELVETICA);
        fontittle.setSize(18);
        Paragraph paragraph=new Paragraph("Hospital Anita \n\n",fontittle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        
        //doctor y cliente
        //cuerpo, tipo de letra, tamaño de letra
        Font fontparagraphdc=FontFactory.getFont(FontFactory.HELVETICA);
        fontparagraphdc.setSize(8);
        String messagesdoctor="\n Doctor a cargo: "+cita.getCita_doctor().getNombre()+" "+cita.getCita_doctor().getApellido()+"\n";
        Paragraph paragraph2=new Paragraph(messagesdoctor,fontparagraphdc);
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
        String pacientedate="\n Paciente: "+cita.getCita_cliente().getNombres()+" "+cita.getCita_cliente().getApellidos()+"\n";
        Paragraph paragraphpaciente=new Paragraph(pacientedate,fontparagraphdc);
        paragraphpaciente.setAlignment(Paragraph.ALIGN_CENTER);

        //Area de atencion
        Font fontparagrapharea=FontFactory.getFont(FontFactory.HELVETICA);
        fontparagrapharea.setSize(8);
        String messagesarea="\n Area a cargo: "+cita.getCita_area().getNombre_Area()+"\n";
        Paragraph paragrapharea=new Paragraph(messagesarea,fontparagraphdc);
        paragrapharea.setAlignment(Paragraph.ALIGN_CENTER);
        //cuerpo, tipo de letra, tamaño de letra
        Font fontparagraph=FontFactory.getFont(FontFactory.HELVETICA);
        fontparagraph.setSize(8);
        String messagesbody="DATOS-CITA: "+cita.getDescripcion();
        Paragraph paragraph3=new Paragraph(messagesbody,fontparagraph);
        paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
        //Fecha de la cita
        Font fontparagraphdate=FontFactory.getFont(FontFactory.HELVETICA);
        fontparagraphdate.setSize(8);
        SimpleDateFormat f=new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String fecha=f.format(cita.getFecha_programacion());
        String messagesfecha="DIA-FECHA PROGRAMADO"+fecha;
        Paragraph paragraph4=new Paragraph(messagesfecha,fontparagraphdate);
        paragraph4.setAlignment(Paragraph.ALIGN_CENTER);

        documentopdf.add(paragraph);
        documentopdf.add(paragraph2);
        documentopdf.add(paragraphpaciente);
        documentopdf.add(paragrapharea);
        documentopdf.add(paragraph3);
        documentopdf.add(paragraph4);
        documentopdf.close();   

    }
}
