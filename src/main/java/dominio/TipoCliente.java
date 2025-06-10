/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Interfaces.Beneficio;
import java.util.Collection;

/**
 *
 * @author maurizio
 */
public class TipoCliente {
    private String nombre;
    private Collection<Beneficio> beneficios;

    public TipoCliente(String nombre, Collection<Beneficio> beneficios) {
        this.nombre = nombre;
        this.beneficios = beneficios;
    }

    public double calcularDescuento(Servicio servicio) {
        return beneficios.stream().mapToDouble(b -> b.calcularBeneficio(servicio)).sum();
    }

    public String getNombre() {
        return nombre;
    }
}
