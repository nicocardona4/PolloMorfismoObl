/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

/**
 *
 * @author maurizio
 */
public class Cliente extends Usuario {
    
    private String clienteNro;
    private Dispositivo dispositivo;
    private TipoCliente tipoCliente;

    public String getClienteNro() {
        return clienteNro;
    }
    
    public Cliente(String nombreCompleto, String password, String clienteNro) {
        super(nombreCompleto, password);
        this.clienteNro = clienteNro;
        this.tipoCliente = new TipoCliente("Comun", List.of()); // Por defecto
        //todo: prceso de asignacion de dispositivo
    }

    public void setTipoBeneficio(TipoCliente clienteTipoBeneficio) {
        this.tipoCliente = clienteTipoBeneficio;
    }
    
    public double calcularDescuento(Servicio servicio) {
        return tipoCliente.calcularDescuento(servicio);
    }

    public String getTipoNombre() {
        return tipoCliente.getNombre();
    }

//    public void abonarServicio(int servicioId){
//        //ToDo
//    }

    @Override
    public boolean esValidoIdentificador(String identificador) {
        //ToDo:Agregar la excepcion
        return identificador.matches("\\d+");
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente other = (Cliente) obj;
        return this.clienteNro.equals(other.clienteNro);
    }
    
}
