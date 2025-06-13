/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(Collection<String> mensajes) {
        super(String.join("\n", mensajes)); // Une todos los mensajes en un solo String, separados por salto de línea
    }
}
