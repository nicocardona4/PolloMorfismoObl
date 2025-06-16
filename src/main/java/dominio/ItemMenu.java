/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
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
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public ItemMenu(String nombre, float precio, Categoria c, UnidadProcesadora uni) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = c;
        this.ingredientes = new ArrayList<>();
        this.up = uni;
        validar();
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

//    void consultarInsumo() {
//        for(Ingrediente i: ingredientes){
//            i.getInsumo().consulta();
//        }
//    }
    private void validar() {
        if (this.nombre.isBlank() || this.nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe ingresar un nombre de item");
        }
        if (this.categoria == null) {
            throw new IllegalArgumentException("Debe ingresar una categoria valida");
        }
        if (this.precio < 1) {
            throw new IllegalArgumentException("Debe ingresar un precio de item");
        }
        if (this.up == null) {
            throw new IllegalArgumentException("Debe ingresar una UP valida");
        }

    }

}
