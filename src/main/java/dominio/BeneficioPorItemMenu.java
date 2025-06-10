/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Interfaces.Beneficio;
import java.util.Set;

/**
 *
 * @author maurizio
 */
public class BeneficioPorItemMenu implements Beneficio  {
    
    
    private Set<ItemMenu> itemsGratis;
    
    public BeneficioPorItemMenu(Set<ItemMenu> itemsGratis) {
        this.itemsGratis = itemsGratis;
    }
    
    @Override
    public double calcularBeneficio(Servicio servicio) {
        return servicio.getPedidos().stream()
                .filter(p -> itemsGratis.contains(p.getItem()))
                .mapToDouble(Pedido::getCostoPedido)
                .sum();
    }
    
    
}
