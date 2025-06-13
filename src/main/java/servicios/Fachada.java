/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.Sesion;
import dominio.TipoCliente;
import dominio.UnidadProcesadora;
import excepciones.LoginException;
import excepciones.StockInsuficienteException;
import java.util.Collection;

/**
 *
 * @author maurizio
 */
public class Fachada {
    private static Fachada instancia = new Fachada();

    private ServicioUsuario servicioUsuario;
    private ServicioPedidos servicioPedidos;
    private ServicioMenu servicioMenu;
    
    
    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
        servicioUsuario = new ServicioUsuario();
        servicioPedidos = new ServicioPedidos();
        servicioMenu = new ServicioMenu();
    }
    
    public Gestor loginGestor(String usuario, String password) throws LoginException {
        return servicioUsuario.loginGestor(usuario, password);
    }

    public Cliente loginCliente(String clienteNro, String password) {
        return servicioUsuario.loginCliente(clienteNro, password);
    }

    public void agregarCliente(Cliente cliente) {
        servicioUsuario.agregarCliente(cliente);
    }

    public void agregarGestor(Gestor gestor) {
        servicioUsuario.agregarGestor(gestor);
    }
    
    public void agregar(Sesion sesion) {
        servicioUsuario.agregar(sesion);
    }

    public void remover(Sesion sesion) {
        servicioUsuario.remover(sesion);
    }

    public Boolean TieneDispositivoEnUso(Cliente cliente) {
        return servicioPedidos.TieneDispositivoEnUso(cliente);
    }
    
    public void agregarUp(UnidadProcesadora up){
        servicioPedidos.agregarUp(up);
    }
    
    public void agregarGestorUP(Gestor gestor, UnidadProcesadora up){
        servicioPedidos.agregarGestorUP(gestor,up);
    }
    
    public Collection<Pedido> getPedidosPorUp(UnidadProcesadora up){
        return servicioPedidos.getPedidosPorUp(up);
    }
    
    public Collection<Dispositivo> getDispositivosDisponibles()
    {
        return servicioPedidos.getDispositivosDisponibles();
    }

    public void agregarDispositivo(Dispositivo d) {
        servicioPedidos.agregarDispositivo(d);
    }
    
    public Servicio getServicioById(int servicioId){
        return servicioPedidos.getServicioById(servicioId);
    }
    
    public void agregarCategoria(Categoria c)
    {
        servicioMenu.agregarCategoria(c);
    }
    
    public Collection<Categoria> getCategorias(){
        return servicioMenu.getCategorias();
    }

    public Collection<ItemMenu> getItemsDeCategoria(Categoria c) {
        return servicioMenu.getItemDeCategoria(c);
    }

    public void agregarItem(ItemMenu im) {
        servicioMenu.agregarItem(im);
    }
    
    public Collection<Insumo> getInsumos(){
        return servicioMenu.getInsumos();
    }
    
    public void agregarInsumo(Insumo insumo){
         servicioMenu.agregarInsumo(insumo);
    }
    
    
    public void agregarPedido(Pedido p){
        servicioPedidos.agregarPedido(p);
    }
    
    public Gestor obtenerGestorDePedido(Pedido pedido) {
        return servicioUsuario.obtenerGestorDePedido(pedido);
    }
    
    public void agregarTipoCliente(Cliente c, TipoCliente tc){
        servicioUsuario.agregarTipoCliente(c,tc);
    }
    
    public void agregarServicio(Servicio s){
        servicioPedidos.agregarServicio(s);
    }

    public Pedido agregarPedido(ItemMenu itemSeleccionado, String comentario, Servicio servicio) {
        return servicioPedidos.agregarPedido(itemSeleccionado, comentario,servicio);
    }

    public void EliminarPedido(Pedido p, Servicio servicio) {
        servicioPedidos.eliminarPedido(p,servicio);
    }
    
    public void confirmarPedido(Pedido p){
        servicioPedidos.confirmarPedido(p);
    }

    public void consultarStock(Collection<Pedido> pedidos) throws StockInsuficienteException {
        servicioPedidos.consultarStock(pedidos);
    }


}
