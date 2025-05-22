/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriopollomorfismo;

import dominio.Cliente;
import dominio.Gestor;
import servicios.Fachada;


public class PrecargaDatos {
    
    public static void main(String[] args) {
        cargar();
    }
    public static void cargar() {
    Fachada f = Fachada.getInstancia();

    Cliente juan = new Cliente("Juan Perez", "pass","1464");
    f.agregar(juan);

    Cliente pedro = new Cliente("Pedro Picapiedra", "pass2","24441");
    f.agregar(pedro);

    Cliente pablo = new Cliente("Pablo Marmol", "pass3","304859");
    f.agregar(pablo);

    Gestor gestorComercial = new Gestor("carlosg", "pass123", "Carlos Gómez", "gestor comercial");
    f.agregar(gestorComercial);

    Gestor gestorSoporte = new Gestor("lauram", "pass1234", "Laura Martínez", "gestor soporte");
    f.agregar(gestorSoporte);


    Cliente cLogueado = f.loginCliente("1464", "pass");
    System.out.println(cLogueado != null ? "Login cliente exitoso: " + cLogueado.getNombreCompleto() : "Login cliente fallido");

    Gestor gLogueado = f.loginGestor("lauram", "pass1234");
    System.out.println(gLogueado != null ? "Login gestor exitoso: " + gLogueado.getNombreCompleto() : "Login gestor fallido ERROR");

    Gestor gInvalido = f.loginGestor("lauram", "pass1gh234");
    System.out.println(gInvalido != null ? "Login gestor exitoso (ERROR)" : "Login gestor fallido correctamente");
}

}
