/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class Pedido {
    private static int contadorPedidoId = 0;
    private int pedidoId;
    private EstadoPedido estadoPedido;
    private ItemMenu item;
    private String descripcion;
    private float costoPëdido;

    public Pedido(ItemMenu item, String descripcion){
        //this.estadoPedido = new EstadoPedido(NoConfirmado());
        this.item = item;
        this.descripcion = descripcion;
        this.costoPëdido = item.getPrecio();
        this.pedidoId = ++contadorPedidoId;
    }
    
    public void confirmarPedido() {
        estadoPedido.confirmarPedido(this);
    }
    
    public void eliminarPedido() {
        estadoPedido.eliminarPedido(this);
    }
    
    public void cobrarPedido() {
        estadoPedido.cobrarPedido(this);
    }
    
    public void entregarPedido() {
        estadoPedido.entregarPedido(this);
    }
    
    public void finalizarPedido() {
        estadoPedido.finalizarPedido(this);
    }
    
    public void setEstado(EstadoPedido estado) {
        this.estadoPedido = estado;
    }
    
    public String getEstadoActual() {
        return estadoPedido.getNombreEstado();
    }

    public ItemMenu getItem() {
        return item;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getPedidoId(){
        return this.pedidoId;
    }
}

