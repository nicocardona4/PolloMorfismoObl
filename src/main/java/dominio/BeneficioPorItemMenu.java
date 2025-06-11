/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Interfaces.Beneficio;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author maurizio
 */
public class BeneficioPorItemMenu implements Beneficio  {
    
    
    private Set<ItemMenu> itemsGratis = new HashSet<>(); ;
    
    public BeneficioPorItemMenu(Set<ItemMenu> itemsGratis) {
        if(itemsGratis!=null){
            this.itemsGratis.addAll(itemsGratis);
        }
    }
    
    // Método para agregar nuevos items
    public void agregaritemGratis(ItemMenu item) {
        itemsGratis.add(item);
    }

    public void agregarItemsGratis(Set<ItemMenu> nuevoItem) {
        itemsGratis.addAll(nuevoItem);
    }
    
    @Override
    public double calcularBeneficio(Servicio servicio) {
        return servicio.getPedidos().stream()
                .filter(p -> itemsGratis.contains(p.getItem()))
                .mapToDouble(Pedido::getCostoPedido)
                .sum();
    }
    
    
}
