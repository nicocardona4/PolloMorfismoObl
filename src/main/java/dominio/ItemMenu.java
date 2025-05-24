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
public class ItemMenu {
    private String nombre;
    private float precio;
    private Collection<Ingrediente> ingredientes;
    private UnidadProcesadora up;

    public ItemMenu(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Collection<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Collection<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public UnidadProcesadora getUp() {
        return up;
    }

    public void setUp(UnidadProcesadora up) {
        this.up = up;
    }
    
    
    
}
