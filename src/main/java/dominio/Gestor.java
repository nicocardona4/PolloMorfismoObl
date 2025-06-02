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
       System.out.println("dominio.Gestor.setPedido(), seteo el pedido con el id de servicio: "+p.getServicioId());
       if(!pedidosAsignados.contains(p)){
           System.out.println("dominio.Gestor.setPedido() lo agrega a la coleccion" );
            this.pedidosAsignados.add(p);
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
}
