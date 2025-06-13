/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;


import dominio.Gestor;
import dominio.UnidadProcesadora;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.TipoOperacionStock;
import excepciones.StockInsuficienteException;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class ServicioPedidos {
    
    private Collection<UnidadProcesadora> ups = new ArrayList<>();
    private Collection<Servicio> servicios = new ArrayList<>();
    private Collection<Pedido> pedidos = new ArrayList();
    private Collection<Dispositivo> dispositivos = new ArrayList();
    private Collection<String> msjStock = new ArrayList();

    //ToDo: Collection de pedidos
    public Collection<Dispositivo> getDispositivosDisponibles() {
        Collection<Dispositivo> disponibles = new ArrayList<>();
        for (Dispositivo d : dispositivos) {
            if (!d.isEnUso()) {
                disponibles.add(d);
            }
        }
        return disponibles;
    }
        
    static void agregarGestorUP(Gestor gestor, UnidadProcesadora up) {
        //Esto estaria gud asi?
        up.setGestor(gestor);
    }

    public Collection<Servicio> getServicios() {
        return servicios;
    }
    
    public Collection<UnidadProcesadora> getUps(){
        return ups;
    }
    
    //Obtener servicio a partir del id
    public Servicio getServicioById(int servicioNro){
        Servicio servicio = new Servicio();
        for(Servicio s : getServicios()){
            if(s.getServicioId()==servicioNro){
                servicio = s;
            }
        }
        return servicio;
    }
    
    public Collection<Pedido> getPedidos() {
        return pedidos;
    }
    

    public Collection<Pedido> getPedidosPorUp(UnidadProcesadora up){
        return up.getPedidosPendientesAsig();
    }
    
    //ToDo: crear metodo para validar si ya existe la up en la coleccion 
    public void agregarUp(UnidadProcesadora up){
        //todo: Agregar exception si existe
        if(!ups.contains(up)){
           ups.add(up);
        }
    }

    public boolean TieneDispositivoEnUso(Cliente c){
        for(Servicio s: servicios){
            if(s.getCliente().equals(c) && s.getEstado().getEstadoNombre()== "Iniciado")
            {
                return true;
            }
        }
    return false;
    }

    public void agregarDispositivo(Dispositivo d) {
        dispositivos.add(d);
    }

    void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    void agregarServicio(Servicio s) {
        servicios.add(s);
    }

    public Pedido agregarPedido(ItemMenu itemSeleccionado, String comentario, Servicio servicio) {
        Pedido p = new Pedido(itemSeleccionado, comentario, servicio);
        pedidos.add(p);

        //Servicio servicio = getServicioById(servicioId);
        if (servicio != null) {
            servicio.getPedidos().add(p);
        }

        return p;
}
    
    public void confirmarPedido(Pedido p){
        actualizarStock(p, TipoOperacionStock.CONSUMIR);
        p.setUp(p.getItem().getUp());
        p.getUp().setPedidosPendientesAsig(p);
    }
    
    public void actualizarStock(Pedido pedido, TipoOperacionStock operacion) {
    for (Ingrediente ingrediente : pedido.getItem().getIngredientes()) {
        int cantidad = ingrediente.getCantidad();
        Insumo insumo = ingrediente.getInsumo();
        int nuevoStock = insumo.getActualStock();
   //     System.out.println("stock antes " + nuevoStock + " de " + insumo + "CANTIDAD" + cantidad);

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
                System.out.println("CASE");
                if (nuevoStock <= insumo.getMinStock()) {
                    System.out.println("IF");
                    msjStock.add("Lo sentimos, nos hemos quedado sin stock de " + pedido.getItem().getNombre() + "por lo  que hemos quitado el pedido del servicio");
                    
                    eliminarPedidoSinCambioDeStock(pedido, pedido.getServicio());
                    insumo.consulta();
                }
        }
        if(insumo.getActualStock() != nuevoStock){
            insumo.setActualStock(nuevoStock);
 //           System.out.println("DESPUES STOCK " +  ingrediente.getInsumo().getActualStock());
        }
        
    }
}




    void eliminarPedido(Pedido p, Servicio servicio) {
        eliminarPedidoSinCambioDeStock(p,servicio);
        actualizarStock(p, TipoOperacionStock.DEVOLVER);
        
    }

    void consultarStock(Collection<Pedido> pedidosAux) throws StockInsuficienteException {
        msjStock.clear();
        if(pedidosAux != null){
            for(Pedido p: pedidosAux){
                System.out.println(p.getEstadoPedido().getNombreEstado());
                if(p.getEstadoPedido().getNombreEstado() == "Sin confirmar"){
                    actualizarStock(p, TipoOperacionStock.CONSULTAR);
                }
            }

            if (!msjStock.isEmpty()) {
            throw new StockInsuficienteException(msjStock);
            }
        }
        
        
    }

    private void eliminarPedidoSinCambioDeStock(Pedido p, Servicio servicio) {
        servicio.getPedidos().remove(p);
        p.getUp().removePedidoPorEliminacion(p);
    }
    

}
