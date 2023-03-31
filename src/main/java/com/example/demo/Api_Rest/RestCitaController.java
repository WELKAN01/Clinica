package com.example.demo.Api_Rest;

import java.io.Console;
import java.io.IOException;
import java.lang.StackWalker.Option;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.AreasDAO;
import com.example.demo.DAO.CitasDAO;
import com.example.demo.DAO.ClienteDAO;
import com.example.demo.DAO.DoctorDAO;
import com.example.demo.Document.PDFcita;
import com.example.demo.Entity.Areas;
import com.example.demo.Entity.Citas;
import com.example.demo.Entity.Cliente;
import com.example.demo.Entity.Doctor;
import com.example.demo.Service.AreaImp;
import com.example.demo.Service.CitasImp;
import com.lowagie.text.DocumentException;


@RestController
@RequestMapping("/citasapi")
public class RestCitaController {
    @Autowired
    private ClienteDAO Clidao;
    @Autowired
    private CitasImp CIMP;
    @Autowired
    private AreasDAO adao;
    @Autowired
    private CitasDAO cdao;
    @Autowired
    private DoctorDAO dao;
    @Autowired
    private PDFcita pdfcita;
    @GetMapping("/list")
    public ResponseEntity<List<Citas>>citalist(){
        return new ResponseEntity<List<Citas>>(cdao.findAll(),HttpStatus.OK);
    }
    
    // @PostMapping(value = "/send",consumes = {MediaType.APPLICATION_JSON_VALUE})
    // public ResponseEntity<Citas> citasend(@RequestBody Citas cita)throws IOException{
    //     return new ResponseEntity<Citas>(CIMP.savecitas(cita), HttpStatus.CREATED);
    // }

    @PostMapping(value = "/send",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> citasend(@RequestBody Citas cita)throws IOException{
        return new ResponseEntity<String>(CIMP.guardarcitas(cita), HttpStatus.CREATED);
    }

    // @GetMapping("/pdf/{idarea}/{idcliente}/{iddoctor}/{descripcion}")
    // public void Generatepdf(@PathVariable Long idarea,@PathVariable Long idcliente, @PathVariable Long iddoctor,@PathVariable String descripcion
    // ,HttpServletResponse response) throws DocumentException, IOException, ParseException{
    //     response.setContentType("application/pdf");
    //     DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
    //     String currentdatestring=dateFormat.format(new Date());
    //     String headerkey="Content-Disposition";
    //     String headervalue="attachment; filename=pdf_"+currentdatestring+".pdf";     
    //     response.setHeader(headerkey, headervalue);
    //     // System.out.println(fecha);
    //     // DateFormat format=new SimpleDateFormat("DD/mm/YYYY HH:mm:ss");
    //     // Date fechatrans=format.parse(fecha);
    //     Citas citaaux=new Citas();
    //     Optional<Areas> areaoption=adao.findById(idarea);
    //     Optional<Doctor> doctoroption=dao.findById(iddoctor);
    //     Optional<Cliente> clienteotpional=Clidao.findById(idcliente);
    //     if (areaoption.isPresent() && doctoroption.isPresent() && clienteotpional.isPresent()) {
    //         Areas areaind=areaoption.get();
    //         Doctor doctorind=doctoroption.get();
    //         Cliente clienteind=clienteotpional.get();
    //         citaaux.setCita_area(areaind);
    //         citaaux.setCita_cliente(clienteind);
    //         citaaux.setCita_doctor(doctorind);
    //         citaaux.setDescripcion(descripcion);
    //         citaaux.setFecha_programacion(null);
    //     }
    //     pdfcita.export(citaaux,response);
    // }
    @GetMapping("/pdf/{idarea}/{idcliente}/{iddoctor}/{descripcion}/{fecha}")
    public void Generatepdf(@PathVariable Long idarea,@PathVariable Long idcliente, @PathVariable Long iddoctor,@PathVariable String descripcion
    ,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date fecha,HttpServletResponse response) throws DocumentException, IOException, ParseException{
        response.setContentType("application/pdf");
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        String currentdatestring=dateFormat.format(new Date());
        String headerkey="Content-Disposition";
        String headervalue="attachment; filename=pdf_"+currentdatestring+".pdf";     
        response.setHeader(headerkey, headervalue);
        // format.(fecha);
        Citas citaaux=new Citas();
        Optional<Areas> areaoption=adao.findById(idarea);
        Optional<Doctor> doctoroption=dao.findById(iddoctor);
        Optional<Cliente> clienteotpional=Clidao.findById(idcliente);
        if (areaoption.isPresent() && doctoroption.isPresent() && clienteotpional.isPresent()) {
            Areas areaind=areaoption.get();
            Doctor doctorind=doctoroption.get();
            Cliente clienteind=clienteotpional.get();
            citaaux.setCita_area(areaind);
            citaaux.setCita_cliente(clienteind);
            citaaux.setCita_doctor(doctorind);
            citaaux.setDescripcion(descripcion);
            citaaux.setFecha_programacion(fecha);
        }
        pdfcita.export(citaaux,response);
    }
}
