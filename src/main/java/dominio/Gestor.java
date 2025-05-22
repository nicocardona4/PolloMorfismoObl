package dominio;

/**
 *
 * @author maurizio
 */
public class Gestor extends Usuario {
    
    private static int contadorGestorId = 0;  // Para ID autonumerado
    
    private String nombreDeUsuario;
    private int gestorId;
    private String tipoGestor;

    public Gestor(String nombreDeUsuario, String password, String nombreCompleto, String tipoGestor) {
        super(nombreCompleto, password);
        this.nombreDeUsuario = nombreDeUsuario;
        this.tipoGestor = tipoGestor;
        this.gestorId = ++contadorGestorId;  
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

    @Override
    public boolean esValidoIdentificador(String identificador) {
        //ToDo:Agregar la excepcion
        return identificador.matches("[a-zA-Z0-9]+");
    }
}
