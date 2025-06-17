/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.EstadosPedidos;

import dominio.Pedido;
import servicios.Fachada;

/**
 *
 * @author maurizio
 */
public class PedidoNoConfirmado extends EstadoPedido {

    public PedidoNoConfirmado(Pedido p, String nombreEstado) {
        super(p,nombreEstado);
    }
    
    @Override
    public void confirmarPedido() {
        Pedido p = this.getPedido();
        p.setEstado(new PedidoConfirmado(p,"Confirmado"));
        Fachada.getInstancia().confirmarPedido(p);

    }
    
    @Override
    public void eliminarPedido(Pedido pedido) {
        Fachada.getInstancia().EliminarPedido(pedido,pedido.getServicio());
    }
    
    @Override
    public String getNombreEstado() {
        return "Sin confirmar";
    }
    
    @Override
    public boolean esNoConfirmado(){
    return true;
    }
    
}
