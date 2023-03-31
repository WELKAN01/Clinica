package com.example.demo.Api_Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Areas;
import com.example.demo.Service.AreaImp;

@RestController
public class RestAreaController {
    @Autowired
    private AreaImp AI;


    @GetMapping("/listaArea")
    public ResponseEntity<List<Areas>> Listado(){
        return ResponseEntity.status(HttpStatus.OK).body(AI.ListaArea());
    }

    @PostMapping(value = "/guardarArea")
    public ResponseEntity<Areas> guardado(@RequestBody Areas areas){
        return new ResponseEntity<Areas>(AI.GuardarArea(areas), HttpStatus.CREATED);
    }
    // @PostMapping(value = "/guardarAreas",  consumes = {"*/*"})
    // @ResponseStatus(code = HttpStatus.ACCEPTED)
    // public void guardadoArea(@ModelAttribute("area") Areas areas) throws Exception{
    //     AI.GuardarArea(areas);
    // }
    @PutMapping(value = "/ActualizarArea/{id}")
    public ResponseEntity<Areas> actualizar(@RequestBody Areas areas,@PathVariable Long id){
        try {
            Areas a = AI.BuscarArea(id);
            a.setNombre_Area(areas.getNombre_Area());
            a.setDescripcion(areas.getDescripcion());
            return new ResponseEntity<Areas>(AI.GuardarArea(a),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Areas>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/EliminarArea/{id}")
    public ResponseEntity<Object> Eliminar(@PathVariable("id") Long id){
        AI.DeleteArea(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
