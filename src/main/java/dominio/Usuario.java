/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import observer.Observable;

/**
 *
 * @author maurizio
 */

public abstract class Usuario extends Observable{

    public Usuario(String nombreCompleto, String password) {
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        validar();
    }


    private String password;
    private String nombreCompleto;



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

    private void validar() {
        if(this.nombreCompleto.isBlank() || nombreCompleto.isEmpty())throw new IllegalArgumentException("Ingrese nombre completo");
        if(this.password.isBlank() || this.password.isEmpty())throw new IllegalArgumentException("ingrese una password");
    }
}
