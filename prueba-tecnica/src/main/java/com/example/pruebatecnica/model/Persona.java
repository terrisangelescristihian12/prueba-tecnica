package com.example.pruebatecnica.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//Pregunta 1
//aqui creamos el model de la clase Persona
@Getter
@Setter
@AllArgsConstructor
public class Persona {
    private String dni;
    private String appPaterno;
    private String appMaterno;
}
