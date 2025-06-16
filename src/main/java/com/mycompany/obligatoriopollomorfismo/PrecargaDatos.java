/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.obligatoriopollomorfismo;

import Interfaces.Beneficio;
import dominio.BeneficioMontoFijo;
import dominio.BeneficioPorCategoria;
import dominio.BeneficioPorItemMenu;
import dominio.BeneficioPorcentual;
import dominio.Categoria;
import dominio.Cliente;
import dominio.Dispositivo;
import dominio.Gestor;
import dominio.Ingrediente;
import dominio.Insumo;
import dominio.ItemMenu;
import dominio.Pedido;
import dominio.Servicio;
import dominio.TipoCliente;
import dominio.UnidadProcesadora;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import servicios.Fachada;

public class PrecargaDatos {

    public static void main(String[] args) {
        cargar();
    }

    public static void cargar() {
        try {
            Fachada f = Fachada.getInstancia();
            Cliente juan = new Cliente("Juan Perez", "1234", "1234");
            f.agregarCliente(juan);
            BeneficioMontoFijo montoFijo = new BeneficioMontoFijo(500);
            Collection<Beneficio> beneficios = new ArrayList();
            beneficios.add(montoFijo);
            juan.setTipoCliente(new TipoCliente("De La Casa", beneficios));

            Cliente pedro = new Cliente("Pedro Picapiedra", "123", "123");
            f.agregarCliente(pedro);

            Cliente pablo = new Cliente("Pablo Marmol", "pass3", "304859");
            f.agregarCliente(pablo);

            UnidadProcesadora up1 = new UnidadProcesadora("Cocina");
            Gestor gestorComercial = new Gestor("carlosg", "pass1234", "Carlos Gómez", "gestor comercial", up1);
            f.agregarGestor(gestorComercial);
            f.agregarGestorUP(gestorComercial, up1);

            UnidadProcesadora up2 = new UnidadProcesadora("Bar");
            Gestor gestorSoporte = new Gestor("lauram", "pass1234", "Laura Martínez", "gestor soporte", up2);
            f.agregarGestor(gestorSoporte);
            f.agregarGestorUP(gestorSoporte, up2);

            Gestor gestorSoporte2 = new Gestor("maurom", "pass1234", "Mauro Mendez", "gestor soporte 2", up2);
            f.agregarGestor(gestorSoporte2);
            f.agregarGestorUP(gestorSoporte2, up2);

            Dispositivo d1 = new Dispositivo();
            Dispositivo d2 = new Dispositivo();
            Dispositivo d3 = new Dispositivo();
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

            ItemMenu im1 = new ItemMenu("Ensalada", 300, catEntradas, up1);
            ItemMenu im2 = new ItemMenu("Picada completa", 1500, catEntradas, up1);
            ItemMenu entrada1 = new ItemMenu("Provolone", 400, catEntradas, up1);
            ItemMenu entrada2 = new ItemMenu("Mariscos", 1200, catEntradas, up1);

            ItemMenu imPlato1 = new ItemMenu("Chivito canadiense con fritas", 550, catPlatos, up1);
            ItemMenu imPlato2 = new ItemMenu("Ravioles de verduras", 450, catPlatos, up1);
            ItemMenu plato1 = new ItemMenu("Pizza c/huevo", 710, catPlatos, up1);
            ItemMenu plato2 = new ItemMenu("Entraña fina", 420, catPlatos, up1);

            ItemMenu im3 = new ItemMenu("Agua", 100, catBebidas, up2);
            ItemMenu bebida1 = new ItemMenu("Jugo de naranja", 120, catBebidas, up2);
            ItemMenu bebida2 = new ItemMenu("Jugo de frutilla", 120, catBebidas, up2);

            ItemMenu im4 = new ItemMenu("Chajá", 700, catPostres, up1);
            ItemMenu postre1 = new ItemMenu("Principe Humberto", 850, catPostres, up1);
            ItemMenu postre2 = new ItemMenu("Carrot cake", 790, catPostres, up1);

            ItemMenu im5 = new ItemMenu("Vino blanco", 500, catVinos, up2);
            ItemMenu vino1 = new ItemMenu("Vino tinto", 600, catVinos, up2);

            ItemMenu im6 = new ItemMenu("Cortado", 500, catCafes, up2);
            ItemMenu cafe1 = new ItemMenu("Capuccino", 350, catCafes, up2);

            Insumo harina = new Insumo("Harina", 100, 200);
            Insumo azucar = new Insumo("Azúcar", 80, 150);
            Insumo huevos = new Insumo("Huevos", 200, 300);
            Insumo leche = new Insumo("Leche", 60, 100);
            Insumo manteca = new Insumo("Manteca", 50, 100);
            Insumo chocolate = new Insumo("Chocolate", 40, 85);
            Insumo sal = new Insumo("Sal", 150, 250);
            Insumo aceite = new Insumo("Aceite", 70, 150);
            Insumo levadura = new Insumo("Levadura", 30, 500);
            Insumo vainilla = new Insumo("Vainilla", 25, 300);
            Insumo cafe = new Insumo("café", 25, 300);
            Insumo crema = new Insumo("Crema", 25, 300);
            Insumo frutilla = new Insumo("Frutilla", 25, 50);
            Insumo agua = new Insumo("Agua", 10, 13); //DEJAMOS POCO MARGEN DE STOCK PARA PROBAR QUE SE AGOTE
            Insumo naranja = new Insumo("Naranja", 15, 17); //LO MISMO PARA EL JUGO DE NARANJA
            Insumo verduras = new Insumo("Verduras", 10, 15);
            Insumo queso = new Insumo("Queso", 10, 15);
            Insumo mariscos = new Insumo("Mariscos", 10, 15);
            Insumo carne = new Insumo("Carne", 10, 12);

            f.agregarInsumo(queso);
            f.agregarInsumo(mariscos);
            f.agregarInsumo(carne);
            f.agregarInsumo(harina);
            f.agregarInsumo(azucar);
            f.agregarInsumo(huevos);
            f.agregarInsumo(leche);
            f.agregarInsumo(manteca);
            f.agregarInsumo(chocolate);
            f.agregarInsumo(sal);
            f.agregarInsumo(aceite);
            f.agregarInsumo(vainilla);
            f.agregarInsumo(cafe);
            f.agregarInsumo(crema);
            f.agregarInsumo(frutilla);
            f.agregarInsumo(agua);
            f.agregarInsumo(naranja);
            f.agregarInsumo(verduras);

            Ingrediente ingHarina = new Ingrediente("Harina", 2, harina);
            Ingrediente ingAzucar = new Ingrediente("Azúcar", 3, azucar);
            Ingrediente ingLeche = new Ingrediente("Leche", 1, leche);
            Ingrediente ingHuevos = new Ingrediente("Huevos", 4, huevos);
            Ingrediente ingManteca = new Ingrediente("Manteca", 2, manteca);
            Ingrediente ingChocolate = new Ingrediente("Chocolate", 3, chocolate);
            Ingrediente ingCafé = new Ingrediente("Café", 1, cafe);
            Ingrediente ingCrema = new Ingrediente("Crema", 2, crema);
            Ingrediente ingVainilla = new Ingrediente("Vainilla", 1, vainilla);
            Ingrediente ingFrutilla = new Ingrediente("Frutilla", 1, frutilla);
            Ingrediente ingAgua = new Ingrediente("Agua", 1, agua);
            Ingrediente ingNaranja = new Ingrediente("Naranja", 1, naranja);
            Ingrediente ingVerduras = new Ingrediente("Verduras", 1, verduras);
            Ingrediente ingMarisctos = new Ingrediente("Mariscos", 1, mariscos);
            Ingrediente ingQueso = new Ingrediente("Queso", 1, queso);
            Ingrediente ingCarne = new Ingrediente("Carne", 1, carne);

            // Ensalada
            im1.getIngredientes().add(ingLeche);      // Aderezo cremoso
            im1.getIngredientes().add(ingCrema);      // Para suavidad
            im1.getIngredientes().add(ingFrutilla);   // Toque fresco/frutal

            // Picada completa
            im2.getIngredientes().add(ingHarina);     // Pan
            im2.getIngredientes().add(ingManteca);    // Para acompañamiento
            im2.getIngredientes().add(ingChocolate);  // Toque dulce
            im2.getIngredientes().add(ingVainilla);   // Aderezo aromático

            entrada1.getIngredientes().add(ingQueso);
            entrada2.getIngredientes().add(ingMarisctos);

            //Ravioles de verdura
            imPlato2.getIngredientes().add(ingVerduras);

            //Chivito
            imPlato1.getIngredientes().add(ingHuevos);
            imPlato1.getIngredientes().add(ingManteca);
            imPlato1.getIngredientes().add(ingHarina);

            plato1.getIngredientes().add(ingHarina);
            plato1.getIngredientes().add(ingHuevos);

            plato2.getIngredientes().add(ingCarne);

            // Agua
            im3.getIngredientes().add(ingAgua);

            // Chajá (postre uruguayo típico)
            im4.getIngredientes().add(ingHarina);     // Bizcochuelo
            im4.getIngredientes().add(ingAzucar);     // Merengue
            im4.getIngredientes().add(ingHuevos);     // Bizcochuelo
            im4.getIngredientes().add(ingFrutilla);   // Decoración/fruta
            im4.getIngredientes().add(ingCrema);      // Relleno

            // Vino blanco
            // Generalmente no se descompone en ingredientes reales, pero podemos simularlo
            im5.getIngredientes().add(ingVainilla);   // Nota aromática
            im5.getIngredientes().add(ingAzucar);     // Para suavidad
            im5.getIngredientes().add(ingFrutilla);   // Toque frutal

            vino1.getIngredientes().add(ingAzucar);
            vino1.getIngredientes().add(ingFrutilla);

            postre1.getIngredientes().add(ingChocolate);
            postre2.getIngredientes().add(ingLeche);
            postre1.getIngredientes().add(ingAzucar);
            postre2.getIngredientes().add(ingAzucar);

            im6.getIngredientes().add(ingCafé);   //CAFE
            cafe1.getIngredientes().add(ingCafé);

            bebida1.getIngredientes().add(ingNaranja);
            bebida2.getIngredientes().add(ingFrutilla);

            f.agregarItem(im1);
            f.agregarItem(im2);
            f.agregarItem(im3);
            f.agregarItem(im4);
            f.agregarItem(im5);
            f.agregarItem(im6);
            f.agregarItem(cafe1);
            f.agregarItem(imPlato1);
            f.agregarItem(imPlato2);
            f.agregarItem(bebida1);
            f.agregarItem(bebida2);
            f.agregarItem(entrada1);
            f.agregarItem(entrada2);
            f.agregarItem(plato1);
            f.agregarItem(plato2);
            f.agregarItem(vino1);
            f.agregarItem(postre1);
            f.agregarItem(postre2);

            Set<ItemMenu> itemsGratis = Set.of(im3);

            TipoCliente preferencial = new TipoCliente("Preferencial", List.of(
                    new BeneficioPorItemMenu(itemsGratis), // Item agua
                    new BeneficioPorcentual(5.0, 2000.0) // 5% si el total > 2000
            ));

            TipoCliente frecuentes = new TipoCliente("Frecuente", List.of(
                    new BeneficioPorCategoria(Set.of(catCafes))
            ));

            TipoCliente deLaCasa = new TipoCliente("De la casa", List.of(
                    new BeneficioMontoFijo(500.0)
            ));

            TipoCliente comun = new TipoCliente("Comun", List.of());

            f.agregarTipoCliente(juan, frecuentes);

            Servicio sJuan = new Servicio(pablo);
            Pedido p1 = new Pedido(im1, "Ensalada de la casa", sJuan);
            Pedido p2 = new Pedido(im2, "Las papas bien crocantes", sJuan);
            Pedido p3 = new Pedido(im3, "Agua c/gas", sJuan);
            Pedido p4 = new Pedido(im3, "Agua s/gas", sJuan);

            p1.setUp(up2);
            p2.setUp(up2);
            p3.setUp(up2);
            p4.setUp(up2);

            f.agregarPedido(p4);
            f.agregarPedido(p3);
            f.agregarPedido(p2);
            f.agregarPedido(p1);
            f.agregarServicio(sJuan);

            p1.confirmarPedido();
            p2.confirmarPedido();
            p3.confirmarPedido();
            p4.confirmarPedido();

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
