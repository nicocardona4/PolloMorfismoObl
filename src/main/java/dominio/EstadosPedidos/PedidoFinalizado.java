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
public class PedidoFinalizado extends EstadoPedido {

    public PedidoFinalizado(Pedido p, String nombreEstado) {
        super(p,nombreEstado);
    }
    
    @Override
    public void entregarPedido() {
        Pedido p = this.getPedido();
        System.out.println("Entregando pedido al cliente...");
        p.setEstado(new PedidoEntregado(p,"Entregado"));
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
