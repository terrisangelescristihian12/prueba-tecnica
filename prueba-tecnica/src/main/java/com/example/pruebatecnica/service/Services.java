package com.example.pruebatecnica.service;

import java.util.List;

import com.example.pruebatecnica.model.Persona;

public interface Services {
     //este es el contrato en relacion a la Pregunta 1
     List<Persona>operacion();
     String centros(String nombre);
     String operaciones(String operacion, double num1, double num2);
}
