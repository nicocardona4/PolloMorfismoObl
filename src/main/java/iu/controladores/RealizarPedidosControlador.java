/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.LoginException;
import excepciones.PedidoInvalidoException;
import excepciones.StockInsuficienteException;
import iu.EventosRestaurante;
import iu.ProcesarPedidosVista;
import iu.RealizarPedidosVista;
import iu.RealizarPedidosVistaImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import observer.Observable;
import observer.Observador;
import servicios.Fachada;

/**
 *
 * @author nicoc
 */
public class RealizarPedidosControlador extends BaseVistaControlador<RealizarPedidosVista> implements Observador {

    private RealizarPedidosVistaImpl vista;
    private Dispositivo dispositivo;
    private Servicio servicio = new Servicio();
    private Cliente cliente;
    private List<Categoria> categorias = new ArrayList();
    private List<ItemMenu> itemsVisibles = new ArrayList<>();
    private DefaultTableModel dtm;
    private Collection<Pedido> pedidos = new ArrayList<Pedido>();
    

    public RealizarPedidosControlador(RealizarPedidosVistaImpl vista, Dispositivo d, DefaultTableModel dtm, Servicio servicio1) {
        super(vista);
        this.vista = vista;
        this.dtm = dtm;
        this.dispositivo = d;
        for (Insumo i : Fachada.getInstancia().getInsumos()) {
            suscribirComoObservador(i);
        }
    }

    public void loginIniciar(String clienteNro, String password) {
        try {
            login(clienteNro, password);
        } catch (LoginException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void login(String clienteNro, String password) throws LoginException {
        if (dispositivo.isEnUso()) {
            throw new LoginException("Debe primero finalizar el servicio actual");
        }
        cliente = loginCliente(clienteNro, password);
        if (cliente != null) {
            if (!Fachada.getInstancia().TieneDispositivoEnUso(cliente)) {
                InicializarDispositivo();
            } else {
                throw new LoginException("Ud. ya está identificado en otro dispositivo");
            }

        } else {

            throw new LoginException("Credenciales incorrectas");
        }
    }

    private Cliente loginCliente(String clienteNro, String password) {
        return Fachada.getInstancia().loginCliente(clienteNro, password);
    }

    public void InicializarDispositivo() {
        dispositivo.setEnUso(true);
        servicio = new Servicio(cliente);
        System.out.println(servicio.getServicioId());
        System.out.println(cliente);
        Fachada.getInstancia().agregarServicio(servicio);
        suscribirComoObservador(servicio);
        vista.mostrarCliente(cliente);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventosRestaurante.ACTUALIZACION_STOCK.equals(evento)) {
            System.out.println("ACTUALIZACION DE STOCK RECIBIDA");
            vista.mostrarCategorias(categorias);
//            actualizarItems();
            consultarStock();

        }
        if(EventosRestaurante.FINALIZACION_PEDIDO.equals(evento)){
            actualizarPedidos();
            mostrarMensajeDeError("Teiene pedido para retirar");
            
        }
        if (EventosRestaurante.ACTUALIZACION_SERVICIO.equals(evento)) {
            actualizarPedidos();
            System.out.println("ACTUIALÑIZACION DE SERVICIO");

        }
        if (EventosRestaurante.ASIGNACION_PEDIDO.equals(evento)) {
           actualizarPedidos();
        }

    }

    private void suscribirComoObservador(Observable observable) {
        observable.removerObservador(this);
        observable.agregarObservador(this);
    }

    public void cargarCategorias() {
        categorias = (List<Categoria>) Fachada.getInstancia().getCategorias();
        vista.mostrarCategorias(categorias);
    }

    private void agregarPedidoIniciar(ItemMenu itemSeleccionado, String comentario) throws PedidoInvalidoException {
        Pedido p = Fachada.getInstancia().agregarPedido(itemSeleccionado, comentario, servicio);
        actualizarPedidos();

    }

    public void eliminarPedido(int fila) {
        Pedido p = null;
        if (fila >= 0) {
            p = (Pedido) dtm.getValueAt(fila, 6);
        }
        try {
            p.eliminarPedido();
            actualizarPedidos();
        } catch (IllegalStateException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }
    }

    public void pagoRealizado() {
        servicio.finalizarServicio();
        dispositivo.setEnUso(false);
        double total = servicio.getTotal();
        double descuento = cliente.calcularDescuento(servicio);
        total = total - descuento;
        String mensaje = cliente.getInvitaciones(servicio);
        mostrarMensajeDeError(mensaje);
        
    }

    public void confirmarPedidos() {
        pedidos = servicio.getPedidos();
        for (Pedido p : pedidos) {
            p.confirmarPedido();
            suscribirComoObservador(p.getUp());
        }
        servicio.getTotal();
        actualizarPedidos();

    }


    public void consultarStock() {
        try {
            Fachada.getInstancia().consultarStock(servicio);
        } catch (StockInsuficienteException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }

    }

    public void agregarPedido(int itemIndex, String comentario) {
        try {
            verificarCliente();
            agregarPedidoIniciar(obtenerItemSeleccionado(itemIndex), comentario);
        } catch (LoginException ex) {
            mostrarMensajeDeError(ex.getMessage());
        } catch (PedidoInvalidoException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void verificarCliente() throws LoginException {
        if (cliente == null) {
            throw new LoginException("Debe identificarse antes de realizar pedidos");
        }
    }

    public void categoriaSeleccionada(int index) {
        Categoria categoria = categorias.get(index);
        Collection<ItemMenu> itemsAux = Fachada.getInstancia().getItemsDeCategoria(categoria);

        itemsVisibles.clear();

        for (ItemMenu item : itemsAux) {
            boolean todosConStock = item.getIngredientes().stream()
                    .allMatch(i -> i.getInsumo().hayStock());

            if (todosConStock) {
                itemsVisibles.add(item);
            }
        }

        vista.mostrarItems(itemsVisibles);
    }

    private ItemMenu obtenerItemSeleccionado(int index) throws PedidoInvalidoException {
        if (index < 0) {
            throw new PedidoInvalidoException("Debe seleccionar un item");
        }
        return itemsVisibles.get(index);

    }

    private void actualizarPedidos() {
        List<Object[]> filas = new ArrayList<>();
        dtm.setRowCount(0);
        Gestor gestor = null;
        if (servicio != null) {
            for (Pedido pedido : servicio.getPedidos()) {
                gestor = Fachada.getInstancia().obtenerGestorDePedido(pedido);
                Object[] fila = new Object[7];
                fila[0] = pedido.getItem().getNombre();
                fila[1] = pedido.getDescripcion();
                fila[2] = pedido.getEstadoActual();
                fila[3] = pedido.getUp().getNombre();
                fila[4] = (gestor != null) ? gestor.getNombreCompleto() : "En espera";
                fila[5] = pedido.getCostoPedido();
                fila[6] = pedido;

                dtm.addRow(fila);
                filas.add(fila);
            }
        }
        vista.actualizarPedidos(filas);
    }

    public void calcularMonto() {
        vista.calcularMonto(String.format("Total: $%.2f", servicio.getTotal()));
    }
}


