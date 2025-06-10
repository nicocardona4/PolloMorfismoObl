/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Interfaces.Beneficio;
import dominio.Servicio;
import java.util.Set;

/**
 *
 * @author maurizio
 */
public class BeneficioPorCategoria implements Beneficio {
    
    private Set<Categoria> categoriasGratis;
    
    public BeneficioPorCategoria(Set<Categoria> categoriasGratis) {
        this.categoriasGratis = categoriasGratis;
    }
    
    @Override
    public double calcularBeneficio(Servicio servicio) {
        return servicio.getPedidos().stream()
                .filter(p -> categoriasGratis.contains(p.getItem().getCategoria()))
                .mapToDouble(Pedido::getCostoPedido)
                .sum();
    }
    
}
