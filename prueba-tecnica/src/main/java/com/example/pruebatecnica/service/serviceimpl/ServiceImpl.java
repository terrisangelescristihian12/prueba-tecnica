package com.example.pruebatecnica.service.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pruebatecnica.model.CentroDistribucion;
import com.example.pruebatecnica.model.Persona;
import com.example.pruebatecnica.service.Services;

@Service
public class ServiceImpl implements Services{
    //Pregunta 1
    //aqui creamos la logica para obtener la lista ordenada por dni y luego por apellido paterno
    public List<Persona>operacion(){
        
        List<Persona>persona=new ArrayList<>();

        persona.add(new Persona("32223344", "Ramirez", "Baldeon"));
        persona.add(new Persona("32223344", "Enrique", "Sosa"));
        persona.add(new Persona("12314320", "De la cruz", "Angeles"));
        persona.add(new Persona("12314320", "Aguilar", "Angeles"));

        System.out.println("Lista desordenada");
        for(Persona personajes:persona){
            System.out.println("DNI: "+personajes.getDni()+" "+"Apellido Paterno: "+personajes.getAppPaterno()+" "+"Apellido Materno: "+personajes.getAppMaterno());
        }
        System.err.println("Lista ordenada");
        Collections.sort(persona, Comparator.comparing(Persona::getDni).thenComparing(Persona::getAppPaterno));
        for(Persona personajes: persona){
            System.out.println("DNI: "+personajes.getDni()+" "+"Apellido Paterno: "+personajes.getAppPaterno()+" "+"Apellido Materno: "+personajes.getAppMaterno());
        }
        return persona;
    }
    public String centros(String nombre){
        //ejercicio2
        List<CentroDistribucion> centros;

        centros = new ArrayList<>();
        centros.add(new CentroDistribucion("LURIN", "Comportamiento para LURIN"));
        centros.add(new CentroDistribucion("ICA", "Comportamiento para ICA"));
        centros.add(new CentroDistribucion("TRUJILLO", "Comportamiento para TRUJILLO"));
        centros.add(new CentroDistribucion("HUANUCO", "Comportamiento para HUANUCO"));
            CentroDistribucion centro = centros.stream()
                    .filter(c -> c.getNombre().equalsIgnoreCase(nombre))
                    .findFirst()
                    .orElse(null);
    
            if (centro != null) {
                return centro.getMensaje();
            } else {
                return "Centro de distribución no encontrado";
            }
        }
    @Override
    public String operaciones(String operacion, double num1, double num2){
        switch (operacion) {
            case "suma":
                return "Resultado: " + (num1 + num2);
            case "resta":
                return "Resultado: " + (num1 - num2);
            case "multiplicacion":
                return "Resultado: " + (num1 * num2);
            case "division":
                if (num2 != 0) {
                    return "Resultado: " + (num1 / num2);
                } else {
                    return "Error: División por cero.";
                }
            default:
                return "Operación no válida";
        }
    }
}
