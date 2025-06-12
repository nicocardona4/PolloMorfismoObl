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
public class ServicioIniciado extends EstadoServicio{

    @Override
    public void finalizarServicio(Servicio s) {
        s.setEstado(new ServicioFinalizado());
    }
    
}
