/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import Interfaces.Beneficio;

/**
 *
 * @author maurizio
 */
public class BeneficioMontoFijo implements Beneficio {
    private double montoDescuento;

    public BeneficioMontoFijo(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    @Override
    public double calcularBeneficio(Servicio servicio) {
        double total = servicio.getTotal();
        return Math.min(montoDescuento, total);
    }

    @Override
    public String invitacion(Servicio servicio) {
        return "Descuento de $" + montoDescuento + ". "; 
    }
    
}
