package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.AreasDAO;
import com.example.demo.Entity.Areas;

@Service
public class AreaImp implements AreaService {
    //llamamos a la carpeta Dao ya que ahi tenemos las consultados a la BD
    //utilizamos autowired para declarar la instancia sin llamar al constructor
    @Autowired
    private AreasDAO aDao;


    //se implementa las funciones usadas en el AreaService porque es de tipo interface

    //la funcion guarda el area en la BD
    @Override
    public Areas GuardarArea(Areas areas) {
        return aDao.save(areas);
    }

    //Se extrae de la base de datos todos los datos en lista
    @Override
    public List<Areas> ListaArea() {
        return aDao.findAll();
    }

    //se busca en la base de datos mediante el tipo de datos id y si no se encuentra se valorizara como null
    @Override
    public Areas BuscarArea(Long id) {
        return aDao.findById(id).orElse(null);
    }


    //se elimina en la base de datos una fila mientras que se declare en el parametro dela funcion, se va iliminar
    //usando el dato Id valor long
    @Override
    public void DeleteArea(Long id) {
         aDao.deleteById(id);
    }

}

