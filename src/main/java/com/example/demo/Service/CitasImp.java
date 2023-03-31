package com.example.demo.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.CitasDAO;
import com.example.demo.Document.PDFcita;
import com.example.demo.Entity.Citas;

@Service
public class CitasImp implements CitasService {

    @Autowired
    private CitasDAO cdao;

    @Override
    public String guardarcitas(Citas cita) {
        List<Citas> citaslist=cdao.findAll();
        String rpt;
        int i=0;
        try {
            for (Citas citascoleccion : citaslist) {
                SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formadate=f.format(cita.getFecha_programacion());
                System.out.println("fecha de ahora:"+formadate);
                int valor=citascoleccion.getFecha_programacion().compareTo(cita.getFecha_programacion());
                if(valor==0){
                    i++;
                }
            }
            if (i>=1) {
                throw new UnsupportedOperationException("ya se encuentra una cita en esa fecha y/o hora");
            }else{
                rpt="se guardo con exito";
                cdao.save(cita);
            }
        } catch (UnsupportedOperationException e) {
            rpt=e.toString();
        }
        return rpt;
    }

    @Override
    public Citas savecitas(Citas cita) {
        return cdao.save(cita);
    }
    
}
