/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import iu.EventosRestaurante;
import observer.Observable;

/**
 *
 * @author maurizio
 */
public class Insumo extends Observable {

    private String nombre; //Idem nombre de ingrediente
    private int minStock;
    private int actualStock;

    public Insumo(String nombre, int minStock, int actualStock) {
        this.nombre = nombre;
        this.minStock = minStock;
        this.actualStock = actualStock;
        validar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getActualStock() {
        return actualStock;
    }

    public void setActualStock(int actualStock) {
        avisar(EventosRestaurante.ACTUALIZACION_STOCK);
        this.actualStock = actualStock;

    }

    public Boolean hayStock() {
        return minStock <= actualStock;
    }

    private void validar() {
        if(this.nombre.isBlank() || this.nombre.isEmpty()){
            throw new IllegalArgumentException("Nombre de insumo invalido");
        }
        if(minStock < 1) throw new IllegalArgumentException("el stock minimo debe ser mayor a 0");
        if(this.actualStock < 0) throw new IllegalArgumentException("el stock actual debe ser positivo");

    }

}
