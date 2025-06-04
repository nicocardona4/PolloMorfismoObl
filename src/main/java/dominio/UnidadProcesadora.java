/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import iu.EventosRestaurante;
import java.util.ArrayList;
import java.util.Collection;
import observer.Observable;

/**
 *
 * @author maurizio
 */
public class UnidadProcesadora extends Observable {
    private String nombre;
    private Collection<Gestor> gestores;
    private Collection<Pedido> pedidosPendientesAsig;

    public UnidadProcesadora(String nombre) {
        this.nombre = nombre;
        this.gestores = new ArrayList<>();
        this.pedidosPendientesAsig = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Gestor> getGestores() {
        return gestores;
    }

    public void setGestor(Gestor gestor) {
        if(!this.gestores.contains(gestor))
        this.gestores.add(gestor);
    }
    
    public Collection<Pedido> getPedidosPendientesAsig(){
        return this.pedidosPendientesAsig;
    }
    
    public void setPedidosPendientesAsig(Pedido p){
        if(!pedidosPendientesAsig.contains(p)){
            this.pedidosPendientesAsig.add(p);
        }
    }
    
    //ver de hacer un remove gestor
    //cuando un gestor se asigna un pedido de la up, se remueve
    public void removePedidoPorAsignacion(Pedido p){
        if(pedidosPendientesAsig.contains(p)){
            this.pedidosPendientesAsig.remove(p);
            avisar(EventosRestaurante.ASIGNACION_PEDIDO);
        }
    }
    
    
}
