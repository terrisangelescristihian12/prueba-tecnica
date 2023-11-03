package com.example.pruebatecnica.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.pruebatecnica.model.Persona;
import com.example.pruebatecnica.service.serviceimpl.ServiceImpl;
@RestController
@RequestMapping("/persona")
public class Controller {
    
    @Autowired
    private ServiceImpl service;
    //Pregunta 1
    //aqui se obtiene la lista ordenada por dni y luego por apellido paterno en caso de que dos o mas dni coincidan
    @GetMapping("/luna")
    public List<Persona>persona(){
        return service.operacion();
    }

//Pregunta 2
//aqui obtenemos un metodo que recibe un parametro de tipo String nombre con el cual obtenemos diferentes comportamientos
@GetMapping("/{nombre}")
public String Comportamiento(@PathVariable String nombre){
    return service.centros(nombre);
}
    //ejercicio 3
@GetMapping("/calcular")
    public String calcular(
        @RequestParam("operacion") String operacion,
        @RequestParam("num1") double num1,
        @RequestParam("num2") double num2) {
        return service.operaciones(operacion,num1,num2);
    }
}