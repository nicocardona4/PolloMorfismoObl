/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import dominio.Gestor;
import dominio.Usuario;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author maurizio
 */
public class ServicioUsuario {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    
    public Collection<Usuario> getUsuarios() {
        return usuarios.values();
    }
    
    public Cliente loginCliente(String usuario, String password) {
        Usuario u = loginGenerico(usuario, password);
        if (u instanceof Cliente) {
            return (Cliente) u;
        }
        return null;
    }

    public <T extends Usuario> T login(Class<T> type, String usuario, String password) {
        Usuario u = loginGenerico(usuario, password);

        if (type.isInstance(u)) {
            return type.cast(u);
        }
        return null;
    }

    public void agregar(Usuario usuario) {
        if (usuario != null) {
            usuarios.put(usuario.getNombreDeUsuario(), usuario);
        }
    }

    private Usuario loginGenerico(String usuario, String password) {
        Usuario u = null;

        if (existe(usuario)) {
            u = getUsuario(usuario);
            if (!u.esValido(password)) {
                u = null;
            }
        }

        return u;
    }

    private Usuario getUsuario(String usuario) {
        return usuarios.get(usuario);
    }

    private boolean existe(String usuario) {
        return usuarios.containsKey(usuario);
    }

    public Gestor loginGestor(String usuario, String password) {
        return null;
    }

//  private void mostrarTiposDeUsuario() {
//    cbTipoUsuario.addItem(Cliente.class);
//    cbTipoUsuario.addItem(Gestor.class);
//}

}
