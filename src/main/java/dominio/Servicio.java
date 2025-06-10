/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class Servicio {
    private static int contadorServicioId = 0;
    
    private int servicioId;
    private Collection<Pedido> pedidos = new ArrayList<Pedido>();
    private float total=0;
    private Cliente cliente;

    public Servicio() {
        this.servicioId = ++contadorServicioId;
    }
    
    public Servicio(Cliente cliente) {
        this.servicioId = ++contadorServicioId;
        System.out.println("dominio.Servicio.<init>() "+ cliente.getClienteNro() + " servicioId "+ servicioId);
        this.cliente = cliente;
    }

    public int getServicioId() {
        return servicioId;
    }
    
    public float getTotal() {
        
        for(Pedido p:pedidos){
            if(p.getEstadoActual() == "Confirmado"){
                total += p.getCostoPedido();
            }
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public Collection<Pedido> getPedidos(){
    return pedidos;
    }
    

}
