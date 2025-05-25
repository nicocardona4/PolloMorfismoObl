/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class Pedido {
    private static int contadorPedidoId = 0;
    private int pedidoId;
//    private EstadoPedido estadoPedido;
    private Collection<ItemMenu> items = new ArrayList<ItemMenu>();
    private float costoPëdido;

    public Pedido(float costoPëdido){
//        this.estadoPedido = new EstadoPedido(NoConfirmado());
        this.costoPëdido = costoPëdido;
        this.pedidoId = ++contadorPedidoId;
    }
    
    

    public void ConfirmarPedido() {
    }

}

