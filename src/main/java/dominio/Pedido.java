/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio.EstadosPedidos.EstadoPedido;
import dominio.EstadosPedidos.PedidoNoConfirmado;
import static dominio.TipoOperacionStock.CONSULTAR;
import static dominio.TipoOperacionStock.CONSUMIR;
import static dominio.TipoOperacionStock.DEVOLVER;
import iu.EventosRestaurante;
import java.util.ArrayList;
import java.util.Collection;
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
    private Servicio servicio;
    private UnidadProcesadora up;
            
    public Pedido(ItemMenu item, String descripcion,Servicio servicio){
        this.estadoPedido = new PedidoNoConfirmado(this,"No Confirmado");
        this.item = item;
        this.descripcion = descripcion;
        this.costoPëdido = item.getPrecio();
        this.pedidoId = ++contadorPedidoId;
        this.fechaCreacion = new Date();
        this.servicio = servicio;
        this.up = item.getUp();
    }
    
    public float getCostoPedido(){
    return costoPëdido;
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

    public Servicio getServicio() {
        return servicio;
    }

    public boolean esDeCategoria(Categoria categoria) {
        return this.item.getCategoria().equals(categoria);
    }

//    public void ingredienteInsumoConsulta() {
//        item.consultarInsumo();
//    }

    String validarIngredientes(TipoOperacionStock operacion) {
        String msjStock = "";
        for (Ingrediente ingrediente : getItem().getIngredientes()) {
            int cantidad = ingrediente.getCantidad();
            Insumo insumo = ingrediente.getInsumo();
            int nuevoStock = insumo.getActualStock();

            switch (operacion) {
                case CONSUMIR:
                    if (nuevoStock < insumo.getMinStock()) {
                        throw new IllegalStateException("Stock insuficiente para el insumo: " + insumo.getNombre());
                    }
                    nuevoStock -= cantidad;
                    break;

                case DEVOLVER:
                    nuevoStock += cantidad;
                    break;

                case CONSULTAR:
                    if (nuevoStock <= insumo.getMinStock()) {
                        msjStock = "Lo sentimos, nos hemos quedado sin stock de " + this.getItem().getNombre() + "por lo  que hemos quitado el pedido del servicio";
//                        pedidosAEliminar.put(pedido, "Lo sentimos, nos hemos quedado sin stock de " + pedido.getItem().getNombre() + "por lo  que hemos quitado el pedido del servicio");
//                        this.getServicio().eliminarPedidoSinCambioDeStock(this);
//                        insumo.consulta();
                    }
            }
            if(insumo.getActualStock() != nuevoStock){
                insumo.setActualStock(nuevoStock);
            }
        }
        return msjStock;
    }
    
    void insumoConsulta(){}
}

