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
public class PedidoEntregado extends EstadoPedido {
    
    @Override
    public void cobrarPedido(Pedido pedido) {
        System.out.println("Cobrando pedido entregado...");
        // Lógica de cobro final
    }
    
    @Override
    public String getNombreEstado() {
        return "Entregado";
    }
    
}
