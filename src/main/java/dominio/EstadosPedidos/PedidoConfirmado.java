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
public class PedidoConfirmado  extends EstadoPedido{

    public PedidoConfirmado(String nombreEstado) {
        super(nombreEstado);
    }
    
    @Override
    public void eliminarPedido(Pedido pedido) {
        System.out.println("Eliminando pedido confirmado...");
        // Lógica para eliminar pedido
    }
    
    @Override
    public void cobrarPedido(Pedido pedido) {
        System.out.println("Cobrando pedido confirmado...");
        // Lógica de cobro
    }
    
    @Override
    public void tomarPedido(Pedido pedido) {
        System.out.println("Tomando pedido para proceso...");
        pedido.setEstado(new PedidoEnProceso("En Proceso"));
    }
    
    @Override
    public String getNombreEstado() {
        return "Confirmado";
    }
}
