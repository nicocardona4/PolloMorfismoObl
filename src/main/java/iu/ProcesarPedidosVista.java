/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iu;

import dominio.Pedido;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author maurizio
 */
public interface ProcesarPedidosVista extends BaseVista{

    void mostrarInfoGestor(String infoGestor);

    void mostrarPedidosPendientes(Collection<Pedido> pedidos);

    void mostrarPedidosTomados(List<Object[]> filas);
    
    void tomarPedido();
    
    void finalizarPedido();
    
    void entregarPedido();
}
