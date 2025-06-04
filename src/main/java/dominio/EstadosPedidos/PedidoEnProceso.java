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
public class PedidoEnProceso extends EstadoPedido {

    public PedidoEnProceso(Pedido p, String nombreEstado) {
        super(p,nombreEstado);
    }
    
    @Override
    public void finalizarPedido() {
        Pedido p = this.getPedido();
        System.out.println("Finalizando preparación del pedido...");
        p.setEstado(new PedidoFinalizado(p,"Finalizado"));
    }
    
    @Override
    public void cobrarPedido(Pedido pedido) {
        System.out.println("Cobrando pedido en proceso...");
        // Lógica de cobro
    }
    
    @Override
    public String getNombreEstado() {
        return "En Proceso";
    }
    
    @Override
    public void entregarPedido() {
        throw new IllegalStateException("Debe finalizar el pedido");
    }
}
