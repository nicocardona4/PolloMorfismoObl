/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio.EstadosPedidos.EstadoPedido;
import dominio.EstadosPedidos.PedidoNoConfirmado;
import dominio.ItemMenu;
import iu.EventosRestaurante;
import java.util.Date;
import observer.Observable;

/**
 *
 * @author nicoc
 */
public class Pedido extends Observable{
    private static int contadorPedidoId = 0;
    private int pedidoId;
    private EstadoPedido estadoPedido;
    private ItemMenu item;
    private String descripcion;
    private float costoPëdido;
    private Date fechaCreacion;
    private int servicioId;
    private UnidadProcesadora up;
            
    public Pedido(ItemMenu item, String descripcion,int servicioId){
        this.estadoPedido = new PedidoNoConfirmado(this,"No Confirmado");
        this.item = item;
        this.descripcion = descripcion;
        this.costoPëdido = item.getPrecio();
        this.pedidoId = ++contadorPedidoId;
        this.fechaCreacion = new Date();
        this.servicioId = servicioId;
    }
    
    public void confirmarPedido() {
        estadoPedido.confirmarPedido();
    }
    
    public void eliminarPedido() {
        estadoPedido.eliminarPedido(this);
    }
    
    public void cobrarPedido() {
        estadoPedido.cobrarPedido(this);
    }
    
    public void entregarPedido() {
        estadoPedido.entregarPedido();
    }
    
    public void finalizarPedido() {
        estadoPedido.finalizarPedido();
        avisar(EventosRestaurante.FINALIZACION_PEDIDO);

    }
    
    public void tomarPedido(Gestor gestor){
        estadoPedido.tomarPedido(gestor);
    }
    
    public void setEstado(EstadoPedido estado) {
        this.estadoPedido = estado;
    }
    
    public String getEstadoActual() {
        return estadoPedido.getNombreEstado();
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public ItemMenu getItem() {
        return item;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getPedidoId(){
        return this.pedidoId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public UnidadProcesadora getUp() {
        return up;
    }

    public void setUp(UnidadProcesadora up) {
        this.up = up;
    }

    public int getServicioId() {
        return servicioId;
    }
    
}

