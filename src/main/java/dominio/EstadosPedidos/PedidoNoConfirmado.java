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
public class PedidoNoConfirmado extends EstadoPedido {

    public PedidoNoConfirmado(Pedido p, String nombreEstado) {
        super(p,nombreEstado);
    }
    
    @Override
    public void confirmarPedido(Pedido pedido) {
        System.out.println("Confirmando pedido...");
        pedido.setEstado(new PedidoConfirmado(getPedido(),"Confirmado"));
    }
    
    @Override
    public void eliminarPedido(Pedido pedido) {
        System.out.println("Eliminando pedido no confirmado...");
        // Lógica para eliminar pedido
    }
    
    @Override
    public String getNombreEstado() {
        return "No Confirmado";
    }
    
}
