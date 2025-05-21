/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu;

import dominio.Usuario;
import servicios.Fachada;

/**
 *
 * @author maurizio
 */
public class LoginUsuarioGestorVista extends LoginVista {

    @Override
    public void ejecutarSiguienteCU(Usuario usuario) {
        //Aca va la pantalla del gestor
    }

    @Override
    public Usuario loginInterno(String usuario, String password) {
        return Fachada.getInstancia().loginGestor(usuario, password);
    }
    
}
