/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.EstadosPedidos;

import dominio.EstadoPedido;
import dominio.Pedido;

/**
 *
 * @author maurizio
 */
public class PedidoFinalizado extends EstadoPedido {
    
    @Override
    public void entregarPedido(Pedido pedido) {
        System.out.println("Entregando pedido al cliente...");
        pedido.setEstado(new PedidoEntregado());
    }
    
    @Override
    public void cobrarPedido(Pedido pedido) {
        System.out.println("Cobrando pedido finalizado...");
        // Lógica de cobro
    }
    
    @Override
    public String getNombreEstado() {
        return "Finalizado";
    }
    
}
