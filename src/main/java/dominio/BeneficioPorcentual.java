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
public class BeneficioPorcentual implements Beneficio {

    private double porcentaje;
    private double montoMinimo;

    public BeneficioPorcentual(double porcentaje, double montoMinimo) {
        this.porcentaje = porcentaje;
        this.montoMinimo = montoMinimo;
    }
    
    @Override
    public double calcularBeneficio(Servicio servicio) {
        double total = servicio.getTotal();
        if (total >= montoMinimo) {
            return total * (porcentaje / 100.0);
        }
        return 0.0;
    }
    
}
