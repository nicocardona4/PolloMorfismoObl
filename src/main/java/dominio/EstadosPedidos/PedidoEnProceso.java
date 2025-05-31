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
public class PedidoEnProceso extends EstadoPedido {

    public PedidoEnProceso(String nombreEstado) {
        super(nombreEstado);
    }
    
    @Override
    public void finalizarPedido(Pedido pedido) {
        System.out.println("Finalizando preparación del pedido...");
        pedido.setEstado(new PedidoFinalizado("Finalizado"));
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
}
