/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import dominio.Gestor;
import dominio.Sesion;
import dominio.UnidadProcesadora;
import iu.EventosRestaurante;
import iu.ProcesarPedidosVista;
import javax.swing.table.DefaultTableModel;
import observer.Observable;
import observer.Observador;
import servicios.Fachada;

/**
 *
 * @author maurizio
 */
public class ControladorProcesarPedidos extends ControladorBaseVista<ProcesarPedidosVista> implements Observador{

    private ProcesarPedidosVista vista;
    private Gestor gestor;
//    private Fachada f = Fachada.getInstancia();
    private UnidadProcesadora up;
    private Sesion sesion;
    private DefaultTableModel dtm;
    private Object[] o = new Object[6];
    
    public ControladorProcesarPedidos(ProcesarPedidosVista vista,Gestor gestor) {
        super(vista);
        this.vista = vista;
        this.gestor = gestor;
        inicializarVista();
//        Fachada.getInstancia().agregarObservador(this);
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
    
    private void suscribirComoObservador(UnidadProcesadora up){
        up.removerObservador(this);
        up.agregarObservador(this);
    }
    
    private void crearSesion() {
        this.sesion = new Sesion(this.gestor);
        Fachada.getInstancia().agregar(sesion);
        suscribirComoObservador(up);
    }
    
    //    private void cerrarSesion() {
//        //Validar si tiene pedidos por entregar
//        DefaultTableModel model = (DefaultTableModel) tblPedidos.getModel();
//        int rowCount = model.getRowCount();
//        boolean hayPedidosPorEntregar=false;
//        for (int i = 0; i < rowCount; i++) {
//            Pedido p = (Pedido) model.getValueAt(i, 5); // columna 0 tiene el Pedido
//            if (!p.getEstadoActual().equalsIgnoreCase("Entregado")) {
//                hayPedidosPorEntregar = true;
//                break; 
//            }
//        }
//        if (!hayPedidosPorEntregar) {
//            this.up.removerObservador(this);
//            f.remover(sesion); 
//            dispose(); // cierra la ventana de forma manual
//        } else {
//            mostrarMensajeDeError("Tiene pedidos pendientes"); // ventana sigue abierta
//        }
//    }

    private void inicializarVista() {
        mostrarInfoGestor();
        mostrarPedidosPendientes();
        mostrarPedidosTomados();
    }

    private void mostrarInfoGestor() {
        vista.mostrarInfoGestor(this.gestor);
    }

    private void mostrarPedidosPendientes() {
        vista.mostrarPedidosPendientes(this.up);
    }

    private void mostrarPedidosTomados() {
        vista.mostrarPedidosTomados(this.dtm, this.gestor);
    }
    
    

}
