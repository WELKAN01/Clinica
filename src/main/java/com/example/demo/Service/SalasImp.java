package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AreasDAO;
import com.example.demo.DAO.SalasDAO;
import com.example.demo.Entity.Sala;

@Service
public class SalasImp implements SalasService{

    @Autowired
    private SalasDAO sDao;

    @Override
    public List<Sala> ListSalas() {
        return sDao.findAll();
    }

    @Override
    public Sala GuardarSala(Sala sala) {
        return sDao.save(sala);
    }

    @Override
    public void EliminarSala(Long id) {
        sDao.deleteById(id);
    }
    
}
