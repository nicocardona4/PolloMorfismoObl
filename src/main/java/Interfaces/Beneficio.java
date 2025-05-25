/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import dominio.Servicio;

/**
 *
 * @author nicoc
 */
public interface Beneficio {
    public int calcularDescuento(Servicio servicio);
    public String descripcionBeneficio(Servicio servicio);
}
