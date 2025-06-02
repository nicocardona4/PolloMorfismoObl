/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.EstadosPedidos;

import dominio.Pedido;

/**
 *
 * @author maurizio
 */
public abstract class EstadoPedido {
    
    private Pedido pedido;
    private String nombreEstado;

    public EstadoPedido(Pedido p, String nombreEstado) {
        this.pedido = p;
        this.nombreEstado = nombreEstado;
    }
    
    public Pedido getPedido(){
        return this.pedido;
    }
    
    public void confirmarPedido(Pedido pedido) {
        throw new IllegalStateException("No se puede confirmar el pedido en estado: " + 
                                      this.getClass().getSimpleName());
    }
    
    public void eliminarPedido(Pedido pedido) {
        throw new IllegalStateException("No se puede eliminar el pedido en estado: " + 
                                      this.getClass().getSimpleName());
    }
    
    public void tomarPedido(Pedido pedido) { // o entregarPedido() si lo usas para "tomar"
        throw new IllegalStateException("No se puede tomar...");
    }
    
    public void cobrarPedido(Pedido pedido) {
        throw new IllegalStateException("No se puede cobrar el pedido en estado: " + 
                                      this.getClass().getSimpleName());
    }
    
    public void entregarPedido(Pedido pedido) {
        throw new IllegalStateException("No se puede entregar el pedido en estado: " + 
                                      this.getClass().getSimpleName());
    }
    
    public void finalizarPedido(Pedido pedido) {
        throw new IllegalStateException("No se puede finalizar el pedido en estado: " + 
                                      this.getClass().getSimpleName());
    }
        
    public abstract String getNombreEstado();
}
