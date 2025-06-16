/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dominio.EstadosServicio.EstadoServicio;
import dominio.EstadosServicio.ServicioIniciado;
import static dominio.TipoOperacionStock.CONSULTAR;
import static dominio.TipoOperacionStock.CONSUMIR;
import static dominio.TipoOperacionStock.DEVOLVER;
import excepciones.StockInsuficienteException;
import iu.EventosRestaurante;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import observer.Observable;

/**
 *
 * @author nicoc
 */
public class Servicio extends Observable {

    private static int contadorServicioId = 0;

    private int servicioId;
    private Collection<Pedido> pedidos = new ArrayList<Pedido>();
    private float total = 0;
    private Cliente cliente;
    private EstadoServicio estado;
    private HashMap<Pedido, String> pedidosAEliminar = new HashMap();

    public EstadoServicio getEstado() {
        return estado;
    }

    public String getEstadoNombre() {
        return estado.getEstadoNombre();
    }
    public void setEstado(EstadoServicio estado) {
        this.estado = estado;
    }

    public Servicio() {
        this.servicioId = ++contadorServicioId;
    }

    public Servicio(Cliente cliente) {
        this.servicioId = ++contadorServicioId;
        System.out.println("dominio.Servicio.<init>() " + cliente.getClienteNro() + " servicioId " + servicioId);
        this.cliente = cliente;
        this.estado = new ServicioIniciado();
    }

    public int getServicioId() {
        return servicioId;
    }

    public float getTotal() {
        total = 0;
        for (Pedido p : pedidos) {
            total += p.getCostoPedido();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void finalizarServicio() {
        this.estado.finalizarServicio(this);
    }

    public void consultarStock() throws StockInsuficienteException {
        String msj = "";
        Collection<String> excepciones = new ArrayList();
        if (pedidos != null) {
            for (Pedido p : pedidos) {
                System.out.println(p.getEstadoPedido().getNombreEstado());
                if (p.getEstadoPedido().getNombreEstado() == "Sin confirmar") {
                    msj = actualizarStock(p, TipoOperacionStock.CONSULTAR);
                    if (!msj.isEmpty()) {
                        pedidosAEliminar.put(p, msj);
                    }
                }
            }
            System.out.println(pedidosAEliminar.size());
            for (Map.Entry<Pedido, String> entry : pedidosAEliminar.entrySet()) {
                Pedido p = entry.getKey();
                eliminarPedidoSinCambioDeStock(p);
                excepciones.add(entry.getValue());
//                    p.ingredienteInsumoConsulta();

            }
            throw new StockInsuficienteException(excepciones);
        }
    }

    public String actualizarStock(Pedido pedido, TipoOperacionStock operacion) {
        String msjStock = pedido.validarIngredientes(operacion);

        return msjStock;
    }

    public void eliminarPedidoSinCambioDeStock(Pedido p) {
        this.getPedidos().remove(p);
        p.getUp().removePedidoPorEliminacion(p);
        avisar(EventosRestaurante.ACTUALIZACION_SERVICIO);
    }

    public void TienePedidosPendientes() throws IllegalStateException {
        for (Pedido p : pedidos) {
            if (p.getEstadoActual() == "Sin confirmar") {
                throw new IllegalStateException("Tiene pedidos sin confirmar");
            }

        }
    }
    
    public void FinalizarServicio(){
        estado.finalizarServicio(this);
    }

}
