/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maurizio
 */

public abstract class Usuario {

    public Usuario(String nombreCompleto, String nombre, String password) {
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    private String nombreDeUsuario;
    private String password;
    private String nombreCompleto;

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public boolean esValido(String password) {
        return getPassword().equals(password);
    }

    private String getPassword() {
        return password;
    }
    
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public abstract boolean esValidoIdentificador(String identificador);
}
