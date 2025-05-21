/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maurizio
 */
public class Cliente extends Usuario {
    
    private int clienteNro;
    
    public Cliente(String nombreCompleto, String nombre, String password) {
        super(nombreCompleto, nombre, password);
    }
    
//    public void abonarServicio(int servicioId){
//        //ToDo
//    }

    @Override
    public boolean esValidoIdentificador(String identificador) {
        //ToDo:Agregar la excepcion
        return identificador.matches("\\d+");
    }
    
}
