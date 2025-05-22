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
    
    private String clienteNro;

    public String getClienteNro() {
        return clienteNro;
    }
    
    public Cliente(String nombreCompleto, String password, String clienteNro) {
        super(nombreCompleto, password);
        this.clienteNro = clienteNro;
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
