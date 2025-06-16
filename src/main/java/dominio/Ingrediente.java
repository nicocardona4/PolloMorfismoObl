/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maurizio
 */
public class Ingrediente {

    private String nombre;
    private int cantidad;
    private Insumo insumo;

    public Ingrediente(String nombre, int cantidad, Insumo i) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.insumo = i;
        validar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    private void validar() {
        if (nombre.isBlank() || nombre.isEmpty()) {
            throw new IllegalArgumentException("Ingrese un nombre válido");
        }
        if (cantidad <= 0){
            throw new IllegalArgumentException("La cantidad debe ser un numero positivo");
        }
        if(insumo == null){
            throw new IllegalArgumentException("Insumo invalido");
        }
    }

}
