/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.time.LocalDateTime;

/**
 *
 * @author facun
 */
public class Sesion {

    private Gestor usuario;
    private LocalDateTime ingreso;

    public Sesion(Gestor usuario) {
        this.usuario = usuario;
        this.ingreso = LocalDateTime.now();
    }

    public Gestor getUsuario() {
        return usuario;
    }

    public LocalDateTime getIngreso() {
        return ingreso;
    }
}
