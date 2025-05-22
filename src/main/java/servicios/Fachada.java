/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Cliente;
import dominio.Gestor;

/**
 *
 * @author maurizio
 */
public class Fachada {
    private static Fachada instancia = new Fachada();

    private ServicioUsuario servicioUsuario;
    
    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
        servicioUsuario = new ServicioUsuario();
    }
    
    public Gestor loginGestor(String usuario, String password) {
        return servicioUsuario.loginGestor(usuario, password);
    }

    public Cliente loginCliente(String clienteNro, String password) {
        return servicioUsuario.loginCliente(clienteNro, password);
    }

    public void agregar(Cliente cliente) {
        servicioUsuario.agregarUsuario(cliente);
    }

    public void agregar(Gestor gestor) {
        servicioUsuario.agregarUsuario(gestor);
    }
}
