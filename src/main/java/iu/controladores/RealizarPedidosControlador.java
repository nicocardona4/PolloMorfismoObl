/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import excepciones.LoginException;
import excepciones.PedidoInvalidoException;
import excepciones.StockInsuficienteException;
import iu.EventosRestaurante;
import iu.RealizarPedidosVista;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import observer.Observable;
import observer.Observador;
import servicios.Fachada;

/**
 *
 * @author nicoc
 */
public class RealizarPedidosControlador extends BaseVistaControlador<RealizarPedidosVista> implements Observador {

    private RealizarPedidosVista vista;
    private Dispositivo dispositivo;
    private Servicio servicio = new Servicio();
    private Cliente cliente;
    private List<Categoria> categorias = new ArrayList();
    private List<ItemMenu> itemsVisibles = new ArrayList<>();
    private DefaultTableModel dtm;
    private Collection<Pedido> pedidos = new ArrayList<Pedido>();
    private int indiceCategoriaSeleccionada;

    public RealizarPedidosControlador(RealizarPedidosVista vista, Dispositivo d, DefaultTableModel dtm) {
        super(vista);
        this.vista = vista;
        this.dtm = dtm;
        this.dispositivo = d;
        for (Insumo i : Fachada.getInstancia().getInsumos()) {
            suscribirComoObservador(i);
        }
        vista.servicioFinalizadoConExito(false);
    }

    public void loginIniciar(String clienteNro, String password) {
        try {
            limpiarMensajeDeError();
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
        this.servicio = new Servicio(cliente);
        Fachada.getInstancia().agregarServicio(servicio);
        suscribirComoObservador(servicio);
        vista.mostrarCliente(cliente);
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventosRestaurante.ACTUALIZACION_STOCK.equals(evento)) {
            consultarStock();
            //vista.mostrarCategorias(categorias);
            categoriaSeleccionada(indiceCategoriaSeleccionada);
        }
        if (EventosRestaurante.FINALIZACION_PEDIDO.equals(evento)) {
            actualizarPedidos();
            mostrarMensajeDeError("Un pedido ha finalizado, ya lo puede retirar");
        }
        if (EventosRestaurante.ACTUALIZACION_SERVICIO.equals(evento) || EventosRestaurante.ASIGNACION_PEDIDO.equals(evento)
                || EventosRestaurante.ENTREGA_PEDIDO.equals(evento)){
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
            limpiarMensajeDeError();
            verificarCliente("eliminar pedidos");
            validarIndice(fila, "pedido");
            p.eliminarPedido();
            actualizarPedidos();
            calcularMonto();
        } catch (LoginException | PedidoInvalidoException | IllegalStateException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }
    }

    public void pagoRealizado() {
        limpiarMensajeDeError();
        dispositivo.setEnUso(false);
        double total = servicio.getTotal();
        double descuento = cliente.calcularDescuento(servicio);
        total = total - descuento;
        String mensaje = cliente.getInvitaciones(servicio);
        mensaje += "Monto subtotal : $" + servicio.getTotal() + " - " + "beneficio: $" + descuento + " Monto a pagar: $" + total;
        vista.mostrarMensaje(mensaje);
        cerrarSesion();
    }

    public void confirmarPedidos() {
    List<Pedido> pedidos = new ArrayList<>(servicio.getPedidos());
    boolean algunoConfirmado = false;

    int i = 0;
    while (i < pedidos.size()) {
        Pedido p = pedidos.get(i);

        if (p.getEstadoActual().equals("Sin confirmar")) {
            algunoConfirmado = true;
        }

        suscribirComoObservador(p);

        try {
            limpiarMensajeDeError();
            p.confirmarPedido();  // si modifica la lista, no rompe el while
            suscribirComoObservador(p.getUp());
        } catch (IllegalStateException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }

        i++;
    }

    if (!algunoConfirmado) {
        mostrarMensajeDeError("No hay pedidos para confirmar");
    }

    servicio.getTotal();
    actualizarPedidos();
}


    public void consultarStock() {
        try {
            limpiarMensajeDeError();
            Fachada.getInstancia().consultarStock(servicio);
        } catch (StockInsuficienteException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }

    }

    public void agregarPedido(int itemIndex, String comentario) {
        try {
            limpiarMensajeDeError();
            verificarCliente("realizar pedidos");
            agregarPedidoIniciar(obtenerItemSeleccionado(itemIndex), comentario);
            calcularMonto();
        } catch (LoginException | PedidoInvalidoException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }
    }

    private void verificarCliente(String accion) throws LoginException {
        if (cliente == null) {
            throw new LoginException("Debe identificarse antes " + accion);
        }
    }

    public void categoriaSeleccionada(int index) {
        indiceCategoriaSeleccionada = index;
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

        validarIndice(index, "item");

        return itemsVisibles.get(index);

    }

    private void validarIndice(int index, String seleccionado) throws PedidoInvalidoException {
        if (index < 0) {
            throw new PedidoInvalidoException("Debe seleccionar un " + seleccionado);
        }
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
                fila[3] = (pedido.getEstadoActual() != "Sin confirmar") ? pedido.getUp().getNombre() : "En espera";
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
        String monto = String.format("%.2f", servicio.getTotal());
        System.out.println("MONTO: " + monto);
        vista.calcularMonto(monto);
    }

    private void cerrarSesion() {
        cliente = null;
        servicio = null;
        pedidos = null;
    }

    public void finalizarServicio() {
        int pedidosParaRetirar = 0;
        try {
            limpiarMensajeDeError();
            verificarCliente("finalizar el servicio");
            if (verificarPedidos()) {
                servicio.finalizarServicio();
                for(Pedido p:pedidos){
                    if(p.getEstadoActual() == "Confirmado"){
                        pedidosParaRetirar++;
                    }
                }
                mostrarMensajeDeError("Tienes " + pedidosParaRetirar + " pedidos en proceso, recuerda ir a retirarlos!");
                vista.mostrarMensaje("Pago realizado");
                vista.servicioFinalizadoConExito(true);
            }
        } catch (LoginException | IllegalStateException ex) {
            mostrarMensajeDeError(ex.getMessage());
        }
    }

    private Boolean verificarPedidos() {
        if (pedidos.size() == 0 || pedidos == null) {
            return false;
        }
        return true;
    }
}
