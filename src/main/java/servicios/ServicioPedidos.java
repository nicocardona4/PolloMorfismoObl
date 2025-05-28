/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Gestor;
import dominio.Pedido;
import dominio.Servicio;
import dominio.UnidadProcesadora;
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
    //ToDo: Collection de pedidos

        
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
    
    public Collection<Pedido> getPedidos() {
        return pedidos;
    }
    
    //ToDo: crear metodo para validar si ya existe la up en la coleccion 
    public void agregarUp(UnidadProcesadora up){
        //todo: Agregar exception si existe
        if(!ups.contains(up)){
           ups.add(up);
        }
    }
}
