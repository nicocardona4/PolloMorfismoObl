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
    private float total;
    private Cliente cliente;

    public Servicio(float total, Cliente cliente) {
        this.servicioId = ++contadorServicioId;
        this.total = total;
        this.cliente = cliente;
    }
    
}
