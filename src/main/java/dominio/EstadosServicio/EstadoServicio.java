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
public abstract class EstadoServicio {
        public abstract void finalizarServicio(Servicio s);
        public abstract String getEstadoNombre();
        public abstract Boolean estaFinalizado();
}
