/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import dominio.Gestor;
import dominio.Pedido;
import dominio.Servicio;
import dominio.Sesion;
import dominio.UnidadProcesadora;
import iu.EventosRestaurante;
import iu.ProcesarPedidosVista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import observer.Observable;
import observer.Observador;
import servicios.Fachada;

/**
 *
 * @author maurizio
 */
public class ProcesarPedidosControlador extends BaseVistaControlador<ProcesarPedidosVista> implements Observador{

    private ProcesarPedidosVista vista;
    private Gestor gestor;
    private UnidadProcesadora up;
    private Sesion sesion;
    private DefaultTableModel dtm;
    private Object[] o = new Object[6];
    
    public ProcesarPedidosControlador(ProcesarPedidosVista vista,DefaultTableModel dtm,Gestor gestor) {
        super(vista);
        this.vista = vista;
        this.gestor = gestor;
        this.up = gestor.getUp();
        this.dtm = dtm;
        inicializarVista();
    }

   @Override
    public void actualizar(Observable origen, Object evento) {
        if (EventosRestaurante.ASIGNACION_PEDIDO.equals(evento)) {
            //Refrescar la lista de pendientes, en este caso se asigno alguno
            //de los pedidos pendientes a este u otro gestor. Por lo tanto se debe borrar
            //y cargar de nuevo la lista
            mostrarPedidosPendientes();
            mostrarPedidosTomados();
        }
    }

    @Override
    public void cerrarVista() {
        cerrarSesion();
    }
    
    private void suscribirComoObservador(UnidadProcesadora up){
        up.removerObservador(this);
        up.agregarObservador(this);
    }
    
    private void crearSesion() {
        this.sesion = new Sesion(this.gestor);
        Fachada.getInstancia().agregar(sesion);
        suscribirComoObservador(up);
    }
    
    public void cerrarSesion() {
        //Validar si tiene pedidos por entregar
        mostrarPedidosTomados();
        boolean hayPedidosPorEntregar=false;
        int rowCount = dtm.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Pedido p = (Pedido) dtm.getValueAt(i, 5);
            if (!p.getEstadoActual().equalsIgnoreCase("Entregado")) {
                hayPedidosPorEntregar = true;
                break; 
            }
        }

        if (!hayPedidosPorEntregar) {
            this.up.removerObservador(this);
            Fachada.getInstancia().remover(sesion);
            super.cerrarVista(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        } else {
            mostrarMensajeDeError("Tiene pedidos pendientes"); // ventana sigue abierta
        }
    }

    private void inicializarVista() {
        mostrarInfoGestor();
        mostrarPedidosPendientes();
        mostrarPedidosTomados();
        crearSesion();
    }

    private void mostrarInfoGestor() {
        vista.mostrarInfoGestor("Gestor: " + gestor.getNombreCompleto() + " | Unidad Procesadora: " + gestor.getUp().getNombre());
    }

    private void mostrarPedidosPendientes() {
        vista.mostrarPedidosPendientes(Fachada.getInstancia().getPedidosPorUp(this.up));
    }

    public void mostrarPedidosTomados() {
        List<Object[]> filas = new ArrayList<>();
        dtm.setRowCount(0);
        for (Pedido pedido : gestor.getPedidosAsignados()) {
            Servicio srv = pedido.getServicio();
            Object[] fila = new Object[6];
            fila[0] = pedido.getItem().getNombre();
            fila[1] = pedido.getDescripcion();
            fila[2] = srv.getCliente().getNombreCompleto();
            fila[3] = pedido.getFechaCreacion();
            fila[4] = pedido.getEstadoActual();
            fila[5] = pedido; // útil para editar/eliminar si querés más adelante
            filas.add(fila);
            dtm.addRow(fila);
        }

        vista.mostrarPedidosTomados(filas); // pasa los datos como parámetro
    }
    
    public void tomarPedido(Pedido p){
        
        if (p != null){
            try {
                limpiarMensajeDeError();
                p.tomarPedido(gestor);
            }catch(IllegalStateException ex){
                mostrarMensajeDeError(ex.getMessage());
            }
        }else{
            mostrarMensajeDeError("Debe seleccionar un pedido");
        }
    }
    
    public void finalizarPedido(int fila){
        Pedido p = null;
        if (fila>=0){
            p = (Pedido) dtm.getValueAt(fila, 5);
        }
        if(p!=null){
            try{
                limpiarMensajeDeError();
                p.finalizarPedido();
                //despues agregar que solo muestre los que estan en proceso/finalizados? asi se pueden entregar?
                mostrarPedidosTomados();
            }catch(IllegalStateException ex){
                mostrarMensajeDeError(ex.getMessage());
            }
            
        }else{
            mostrarMensajeDeError("Debe seleccionar un pedido");
        }
    }
    
    public void entregarPedido(int fila){
        Pedido p = null;
        if (fila>=0)
          p = (Pedido) dtm.getValueAt(fila, 5);
        
        if(p!=null){
            try{
                limpiarMensajeDeError();
                p.entregarPedido();
                //despues agregar que solo muestre los que estan en proceso/finalizados? asi se pueden entregar?
                mostrarPedidosTomados();
            }catch(IllegalStateException ex){
                mostrarMensajeDeError(ex.getMessage());
            }
        }else{
            mostrarMensajeDeError("Debe seleccionar un pedido");
        }
    }
        
 }

