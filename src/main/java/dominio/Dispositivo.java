/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author maurizio
 */
public class Dispositivo {
    private int id;
    private boolean enUso;
    private int ultId = 0;

    public Dispositivo() {
        id = this.getUltId() + 1;
        this.setUltId(id);
    }
    
    public int getId() {
        return id;
    }

    public boolean isEnUso() {
        return enUso;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    private int getUltId() {
        return this.ultId;
    }
    
    private void setUltId(int id){
        this.ultId = id;
    }
    
    
}
