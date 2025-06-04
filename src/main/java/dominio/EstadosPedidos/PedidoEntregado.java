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
public class PedidoEntregado extends EstadoPedido {

    public PedidoEntregado(Pedido p, String nombreEstado) {
        super(p,nombreEstado);
    }
    
    @Override
    public void cobrarPedido(Pedido pedido) {
        System.out.println("Cobrando pedido entregado...");
        // Lógica de cobro final
    }
    
    @Override
    public String getNombreEstado() {
        return "Entregado";
    }
    
    @Override
    public void entregarPedido() {
        throw new IllegalStateException("El pedido ya está entregado");
    }
}
