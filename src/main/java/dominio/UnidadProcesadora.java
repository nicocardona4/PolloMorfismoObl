/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Collection;

/**
 *
 * @author maurizio
 */
public class UnidadProcesadora {
    private String nombre;
    private Collection<Gestor> gestores;
    //Colleccion de pedidos pendientes

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Gestor> getGestores() {
        return gestores;
    }

    public void setGestor(Gestor gestor) {
        this.gestores.add(gestor);
    }
    
    //ver de hacer un remove gestor
    
    
}
