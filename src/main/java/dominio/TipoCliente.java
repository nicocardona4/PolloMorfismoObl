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
        validar();
    }

    public double calcularDescuento(Servicio servicio) {
        return beneficios.stream().mapToDouble(b -> b.calcularBeneficio(servicio)).sum();
    }

    public String getNombre() {
        return nombre;
    }

    public String getInvitaciones(Servicio servicio) {
        StringBuilder sb = new StringBuilder();

        for (Beneficio b : beneficios) {
            String invitacion = b.invitacion(servicio);
            if (invitacion != null && !invitacion.isBlank()) {
                sb.append(invitacion).append("\n");
            }
        }

        return sb.toString().trim();
    }

    private void validar() {

        if (this.nombre.isEmpty() || this.nombre.isBlank()) {
            throw new IllegalArgumentException("Debe ingresar un nombre de cliente tipo");
        }
    }

}
