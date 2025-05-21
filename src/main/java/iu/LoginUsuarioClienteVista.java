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
public class LoginUsuarioClienteVista extends LoginVista{

     @Override
    public void ejecutarSiguienteCU(Usuario usuario) {
        //Aca va la vista de usuario. 
    }

    @Override
    public Usuario loginInterno(String usuario, String password) {
        return Fachada.getInstancia().loginCliente(usuario, password);
    }
    

 
    
}
