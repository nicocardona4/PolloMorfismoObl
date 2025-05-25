/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.obligatoriopollomorfismo;

import iu.LoginPrincipal;

/**
 *
 * @author maurizio
 */
public class ObligatorioPolloMorfismo {

    public static void main(String[] args) {
        PrecargaDatos.cargar();
        new LoginPrincipal().setVisible(true);
    }
}
