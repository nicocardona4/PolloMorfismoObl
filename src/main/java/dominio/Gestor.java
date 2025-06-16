package dominio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author maurizio
 */
public class Gestor extends Usuario {
    
    private static int contadorGestorId = 0;  // Para ID autonumerado
    
    private String nombreDeUsuario;
    private int gestorId;
    private String tipoGestor;
    private UnidadProcesadora up;
    private Collection<Pedido> pedidosAsignados;
    
    public Gestor(String nombreDeUsuario, String password, String nombreCompleto, String tipoGestor, UnidadProcesadora up) {
        super(nombreCompleto, password);
        //ToDo: Agregar los validar de que los datos sean correctos
        this.nombreDeUsuario = nombreDeUsuario;
        this.tipoGestor = tipoGestor;
        this.gestorId = ++contadorGestorId;
        this.up = up;
        this.pedidosAsignados= new ArrayList<>();
        validar();
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public int getGestorId() {
        return gestorId;
    }

    public String getTipoGestor() {
        return tipoGestor;
    }

    public void setUp(UnidadProcesadora up) {
        this.up = up;
    }

    public UnidadProcesadora getUp() {
        return up;
    }
    
    public void setPedido(Pedido p){
        //Asigno pedido de la up y luego se la quito para que no quede como pendiente
       if(!pedidosAsignados.contains(p)){
            this.pedidosAsignados.add(p);
            System.out.println("Elimino el pedido: "+ p.getDescripcion() + " de la up: "+ this.getUp().getNombre());
            this.getUp().removePedidoPorAsignacion(p);
       }
    }
       
    public Collection<Pedido> getPedidosAsignados(){
        return pedidosAsignados;
    }
    
    public boolean esValidoIdentificador(String identificador) {
        //ToDo:Agregar la excepcion
        return identificador.matches("[a-zA-Z0-9]+");
    }

    private void validar() {
        if(!esValidoIdentificador(nombreDeUsuario) || this.nombreDeUsuario.isBlank() || this.tipoGestor.isEmpty() || this.up == null){
            throw new IllegalArgumentException("Gestor no valido, revise los datos ingresados " + this.nombreDeUsuario);
        }
    }
    
    
}
