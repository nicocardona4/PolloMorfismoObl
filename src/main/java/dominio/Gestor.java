/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maurizio
 */
public class Gestor extends Usuario {
    
    private String nombreDeUsuario;
    private int gestorId;
    private String tipoGestor; //Ver si luego se hace clase
    
    public Gestor(String nombreCompleto, String nombre, String password) {
        super(nombreCompleto, nombre, password);
    }

    @Override
    public boolean esValidoIdentificador(String identificador) {
        //ToDo:Agregar la excepcion
        return identificador.matches("[a-zA-Z0-9]+");
    }
    
}
