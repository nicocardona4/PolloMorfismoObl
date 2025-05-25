/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Pedido;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class ServicioPedidos {
    private Collection<Pedido> pedidos = new ArrayList();

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }
    
}
