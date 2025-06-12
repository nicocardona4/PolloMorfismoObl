/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu.controladores;

import iu.BaseVista;

/**
 *
 * @author maurizio
 */
public abstract class BaseVistaControlador <TVista extends BaseVista> {

    protected TVista vista;

    public BaseVistaControlador(TVista vista) {
        this.vista = vista;
    }
    
    public void cerrarVista() {
        vista.cerrar();
    }

    protected void mostrarMensajeDeError(String mensaje) {
        vista.mostrarMensajeDeError(mensaje);
    }

    protected void limpiarMensajeDeError() {
        vista.limpiarMensajeDeError();
    }
    
}
