/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maurizio
 */
public class Insumo {
    private String nombre; //Idem nombre de ingrediente
    private int minStock;
    private int actualStock;

    public Insumo(String nombre, int minStock, int actualStock) {
        this.nombre = nombre;
        this.minStock = minStock;
        this.actualStock = actualStock;
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
        this.actualStock = actualStock;
    }
    
    
}
