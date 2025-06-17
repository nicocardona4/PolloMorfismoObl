/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio.EstadosServicio;

import dominio.Servicio;

/**
 *
 * @author nicoc
 */
public class ServicioFinalizado extends EstadoServicio{

    @Override
    public void finalizarServicio(Servicio s) {
        throw new IllegalStateException("El servicio ya está finalizado");
    }

    @Override
    public String getEstadoNombre() {
        return "Finalizado";
    }

    @Override
    public Boolean estaFinalizado() {
        return true;
    }
    
}
