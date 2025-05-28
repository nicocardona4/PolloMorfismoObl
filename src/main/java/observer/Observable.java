/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author maurizio
 */
public abstract class Observable {
    private ArrayList<Observador> observadores = new ArrayList<>();
    
    public void agregarObservador(Observador o){
        observadores.add(o);
    }
    
    public void removerObservador(Observador o){
        observadores.remove(o);
    }
    
    protected void avisar(Object evento){
        for(int i = observadores.size()-1;i>=0;i--){
            observadores.get(i).actualizar(this,evento);
        }
    }
}
