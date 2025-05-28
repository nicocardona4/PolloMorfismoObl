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
    private Collection<ItemMenu> items = new ArrayList<ItemMenu>();
    private float costoPëdido;

    public Pedido(float costoPëdido){
//        this.estadoPedido = new EstadoPedido(NoConfirmado());
        this.costoPëdido = costoPëdido;
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
    
    public void agregarItem(ItemMenu item){
        if (!items.contains(item))//Ver si hay que restringir que no lo tenga
            items.add(item);
    }
    
    public void setEstado(EstadoPedido estado) {
        this.estadoPedido = estado;
    }
    
    public String getEstadoActual() {
        return estadoPedido.getNombreEstado();
    }
}

