/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iu;

import dominio.Categoria;
import dominio.Cliente;
import dominio.ItemMenu;
import java.util.List;

/**
 *
 * @author nicoc
 */
public interface RealizarPedidosVista extends BaseVista{
    
    public void servicioFinalizadoConExito(Boolean pago);
    
    public void mostrarCliente(Cliente cliente);
    
    public void mostrarCategorias(List<Categoria> categorias);
    
    public void mostrarMensaje(String mensaje);
    
    public void mostrarItems(List<ItemMenu> itemsVisibles);
    
    public void actualizarPedidos(List<Object[]> filas);
    
    public void calcularMonto(String montoTotal);
}
