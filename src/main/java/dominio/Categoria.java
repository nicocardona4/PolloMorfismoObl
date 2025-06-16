/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Objects;

/**
 *
 * @author nicoc
 */
public class Categoria {

    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;
        validar();

    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    private void validar() {
        if (nombre.isEmpty() || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la categoría no puede ser vacío (\"" + nombre + "\")");
        }
    }

}
