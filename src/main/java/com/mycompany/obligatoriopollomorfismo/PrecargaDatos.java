/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriopollomorfismo;

import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.UnidadProcesadora;
import servicios.Fachada;


public class PrecargaDatos {
    
    public static void main(String[] args) {
        cargar();
    }
    public static void cargar() {
    Fachada f = Fachada.getInstancia();

    Cliente juan = new Cliente("Juan Perez", "cliente1","1234");
    f.agregarCliente(juan);

    Cliente pedro = new Cliente("Pedro Picapiedra", "pass2","24441");
    f.agregarCliente(pedro);

    Cliente pablo = new Cliente("Pablo Marmol", "pass3","304859");
    f.agregarCliente(pablo);


    UnidadProcesadora up1 = new UnidadProcesadora("Cocina");
    Gestor gestorComercial = new Gestor("carlosg", "pass123", "Carlos Gómez", "gestor comercial",up1);
    f.agregarGestor(gestorComercial);
    f.agregarGestorUP(gestorComercial, up1);

    UnidadProcesadora up2 = new UnidadProcesadora("Bar");
    Gestor gestorSoporte = new Gestor("lauram", "pass1234", "Laura Martínez", "gestor soporte",new UnidadProcesadora("Bar"));
    f.agregarGestor(gestorSoporte);
    f.agregarGestorUP(gestorSoporte, up2);

    
    Dispositivo d1 = new Dispositivo();
    Dispositivo d2 = new Dispositivo();
    Dispositivo d3 = new Dispositivo ();
    f.agregarDispositivo(d1);
    f.agregarDispositivo(d2);
    f.agregarDispositivo(d3);

    
}

}
