package com.example.demo.Service;
import java.util.List;
import com.example.demo.Entity.Doctor;


public interface Doctorservice {
    List<Doctor> getDoctor();
    String guardaDoctor(Doctor doctor);
}
