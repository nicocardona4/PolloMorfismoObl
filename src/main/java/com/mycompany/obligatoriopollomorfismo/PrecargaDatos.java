/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriopollomorfismo;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.ItemMenu;
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
    
    Categoria catEntradas = new Categoria("Entradas");
    Categoria catPlatos = new Categoria("Platos principales");
    Categoria catPostres = new Categoria("Postres");
    Categoria catBebidas = new Categoria("Bebidas");
    Categoria catVinos = new Categoria("Vinos");
    Categoria catCafes = new Categoria("Cafés");

    f.agregarCategoria(catEntradas);
    f.agregarCategoria(catPlatos);
    f.agregarCategoria(catPostres);
    f.agregarCategoria(catBebidas);
    f.agregarCategoria(catVinos);
    f.agregarCategoria(catCafes);

    ItemMenu im1 = new ItemMenu("Ensalada", 300, catEntradas);
    ItemMenu im2 = new ItemMenu("Picada completa", 550, catEntradas);
    ItemMenu im3 = new ItemMenu("Agua", 120, catBebidas);
    ItemMenu im4 = new ItemMenu("Chajá", 300, catPostres);
    ItemMenu im5 = new ItemMenu("Vino blanco", 440, catVinos);
    
    f.agregarItem(im1);
    f.agregarItem(im2);
    f.agregarItem(im3);
    f.agregarItem(im4);
    f.agregarItem(im5);

    
}

}
