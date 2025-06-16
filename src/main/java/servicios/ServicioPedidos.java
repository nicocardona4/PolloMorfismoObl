/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Gestor;
import dominio.UnidadProcesadora;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.TipoOperacionStock;
import excepciones.StockInsuficienteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author nicoc
 */
public class ServicioPedidos {

    private Collection<UnidadProcesadora> ups = new ArrayList<>();
    private Collection<Servicio> servicios = new ArrayList<>();
    private Collection<Pedido> pedidos = new ArrayList();
    private Collection<Dispositivo> dispositivos = new ArrayList();
    private HashMap<Pedido, String> pedidosAEliminar = new HashMap();

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

    public Collection<UnidadProcesadora> getUps() {
        return ups;
    }

    //Obtener servicio a partir del id
    public Servicio getServicioById(int servicioNro) {
        Servicio servicio = new Servicio();
        for (Servicio s : getServicios()) {
            if (s.getServicioId() == servicioNro) {
                servicio = s;
            }
        }
        return servicio;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public Collection<Pedido> getPedidosPorUp(UnidadProcesadora up) {
        return up.getPedidosPendientesAsig();
    }

    //ToDo: crear metodo para validar si ya existe la up en la coleccion 
    public void agregarUp(UnidadProcesadora up) {
        //todo: Agregar exception si existe
        if (!ups.contains(up)) {
            ups.add(up);
        }
    }

    public boolean TieneDispositivoEnUso(Cliente c) {
        for (Servicio s : servicios) {
            if (s.getCliente().equals(c) && "Iniciado".equals(s.getEstado().getEstadoNombre())) {
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

    public void confirmarPedido(Pedido p) {
        actualizarStock(p, TipoOperacionStock.CONSUMIR);
        p.setUp(p.getItem().getUp());
        p.getUp().setPedidosPendientesAsig(p);
    }

    void actualizarStock(Pedido pedido, TipoOperacionStock operacion) {
        pedido.getServicio().actualizarStock(pedido, operacion);
    }

    void eliminarPedido(Pedido p, Servicio servicio) {
        if(servicio.getEstadoNombre() == "Finalizado"){
            throw new IllegalStateException("No se puede eliminar pedidos, el servicio ha finalizado");
        }
            servicio.getPedidos().remove(p);
            p.getUp().removePedidoPorEliminacion(p);
            actualizarStock(p, TipoOperacionStock.DEVOLVER);
    }

    void consultarStock(Servicio servicio) throws StockInsuficienteException {
        if (servicio != null) {
            servicio.consultarStock();
        }

    }

}
