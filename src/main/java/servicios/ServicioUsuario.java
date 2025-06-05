/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import dominio.Gestor;
import dominio.Sesion;
import dominio.Usuario;
import excepciones.LoginException;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author maurizio
 */
public class ServicioUsuario {
    private Collection<Usuario> usuarios = new ArrayList<>();
    private Collection<Cliente> clientes = new ArrayList();    
    private Collection<Gestor> gestores = new ArrayList();  
    private ArrayList<Sesion> sesiones = new ArrayList<>();

    public Collection<Cliente> getClientes() {
        return clientes;
    }

    public Collection<Gestor> getGestores() {
        return gestores;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }
    
    Collection<Sesion> getSesiones() {
        return sesiones;
    }
    
    private Cliente getCliente(String clienteNro) {
        for (Cliente c : clientes) {
            if (c != null){System.out.println(c.getNombreCompleto());}
            if (c.getClienteNro().equals(clienteNro)) {
                return c;  
            }
        }
        return null;
    }

    private Gestor getGestor(String nombreUsuario) {
        for (Gestor g : gestores) {
            if (g.getNombreDeUsuario().equals(nombreUsuario)) {
                return g; 
            }
        }
        return null;
    }


    public Cliente loginCliente(String clienteNro, String password) {
        Cliente cliente = getCliente(clienteNro);
 
        if (cliente != null && cliente.esValido(password)) {
            return cliente;
        }
        return null;
    }

    public Gestor loginGestor(String nombreUsuario, String password) throws LoginException {
        Gestor gestor = getGestor(nombreUsuario);
        
        //valido primero que no este logueado
        for(Sesion s:this.getSesiones()){
            System.out.println("nombreusuario:"+s.getUsuario().getNombreDeUsuario());
            System.out.println("nombreusuario:"+gestor.getNombreDeUsuario());
            if(s.getUsuario().getNombreDeUsuario().equals(gestor.getNombreDeUsuario())){
                System.out.println("llego aca");
                throw new LoginException("El gestor ya se encuentra logueado");
            }
        }
       
        if (gestor != null && gestor.esValido(password)) {
            return gestor;
        }
        return null;
    }
    
    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }
    public void agregarGestor(Gestor g) {
        gestores.add(g);
    }
    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public void agregar(Sesion sesion) {
        sesiones.add(sesion);
//        avisar(EventosAgenda.ALTA_DE_SESION);
    }

    public void remover(Sesion sesion) {
        sesiones.remove(sesion);
//        avisar(EventosAgenda.BAJA_DE_SESION);
    }
    
//        public Cliente loginCliente(String clienteNro, String password) {
//        Usuario u = loginGenerico(clienteNro, password, Cliente.class);
//        return (Cliente) u;
//    }
//
//    public Gestor loginGestor(String nombre, String password) {
//        Usuario u = loginGenerico(nombre, password, Gestor.class);
//        return (Gestor) u;
//    }
//
//    private <T extends Usuario> Usuario loginGenerico(String identificador, String password, Class<T> tipo) {
//        Usuario u = getUsuario(identificador, tipo);
//        if (u != null && u.esValido(password)) {
//            return u;
//        }
//        return null;
//    }
//
//    public <T extends Usuario> T getUsuario(String identificador, Class<T> tipo) {
//        for (Usuario u : usuarios) {
//            if (tipo.equals(Cliente.class) && u instanceof Cliente cliente) {
//                if (cliente.getClienteNro().equals(identificador)) {
//                    return tipo.cast(cliente);
//                }
//            }
//            if (tipo.equals(Gestor.class) && u instanceof Gestor gestor) {
//                if (gestor.getNombreDeUsuario().equals(identificador)) {
//                    return tipo.cast(gestor);
//                }
//            }
//        }
//        return null;
//    }
}
