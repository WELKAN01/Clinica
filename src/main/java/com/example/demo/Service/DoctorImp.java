package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.DoctorDAO;
import com.example.demo.Entity.Doctor;

@Service
public class DoctorImp implements Doctorservice {

    @Autowired
    private DoctorDAO Dao;

    @Override
    public List<Doctor> getDoctor() {
        return Dao.findAll();
    }

    @Override
    public String guardaDoctor(Doctor doctor) {
        List<Doctor> auxdoctor=Dao.findAll();
        String rpt="";
        int count=0;
        try {
            for (Doctor doctor2 : auxdoctor) {
                System.out.println(doctor2.getNombre()+"||||||"+doctor.getNombre());
                if (doctor.getNombre().toLowerCase().equals(doctor2.getNombre().toLowerCase())) {
                    count++;   
                }
            } 
            if(count>=1){
                System.out.println(count);
                throw new Error("se ha encontrado duplicados");
            }else{
                Dao.save(doctor);
                rpt="se guardo exitosamente";  
            }
        } catch (Error e) {
            rpt=e.getMessage();
        }
        return rpt;
    }
    
}
