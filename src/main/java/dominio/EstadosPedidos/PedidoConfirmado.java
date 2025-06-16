/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.EstadosPedidos;

import dominio.Gestor;
import dominio.Pedido;
import servicios.Fachada;

/**
 *
 * @author maurizio
 */
public class PedidoConfirmado  extends EstadoPedido{

    public PedidoConfirmado(Pedido p, String nombreEstado) {
        super(p,nombreEstado);
    }
    
    @Override
    public void eliminarPedido(Pedido pedido) throws IllegalStateException{
//        System.out.println("Eliminando pedido confirmado...");
        Fachada.getInstancia().EliminarPedido(pedido,pedido.getServicio());
    }
    
    @Override 
    public void confirmarPedido() {
    }
    
    @Override
    public void cobrarPedido(Pedido pedido) {
  //      System.out.println("Cobrando pedido confirmado...");
        // Lógica de cobro
    }
    
    @Override
    public void tomarPedido(Gestor gestor) {
  //      System.out.println("Tomando pedido para proceso...");
        Pedido p = this.getPedido();
        p.setEstado(new PedidoEnProceso(p,"En Proceso"));
        gestor.setPedido(p);
    }
    
    @Override
    public String getNombreEstado() {
        return "Confirmado";
    }
    

}
