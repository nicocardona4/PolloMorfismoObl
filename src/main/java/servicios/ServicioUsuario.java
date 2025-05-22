/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import dominio.Gestor;
import dominio.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author maurizio
 */
public class ServicioUsuario {
    private Collection<Usuario> usuarios = new ArrayList<>();
    
    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }
    
        public Cliente loginCliente(String clienteNro, String password) {
        Usuario u = loginGenerico(clienteNro, password, Cliente.class);
        return (Cliente) u;
    }

    public Gestor loginGestor(String nombre, String password) {
        Usuario u = loginGenerico(nombre, password, Gestor.class);
        return (Gestor) u;
    }

    private <T extends Usuario> Usuario loginGenerico(String identificador, String password, Class<T> tipo) {
        Usuario u = getUsuario(identificador, tipo);
        if (u != null && u.esValido(password)) {
            return u;
        }
        return null;
    }

    public <T extends Usuario> T getUsuario(String identificador, Class<T> tipo) {
        for (Usuario u : usuarios) {
            if (tipo.equals(Cliente.class) && u instanceof Cliente cliente) {
                if (cliente.getClienteNro().equals(identificador)) {
                    return tipo.cast(cliente);
                }
            }
            if (tipo.equals(Gestor.class) && u instanceof Gestor gestor) {
                if (gestor.getNombreDeUsuario().equals(identificador)) {
                    return tipo.cast(gestor);
                }
            }
        }
        return null;
    }

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }

}
