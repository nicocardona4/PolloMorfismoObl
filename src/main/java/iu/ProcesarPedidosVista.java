/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iu;

import dominio.Gestor;
import dominio.UnidadProcesadora;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maurizio
 */
public interface ProcesarPedidosVista extends BaseVista{

    void mostrarInfoGestor(Gestor gestor);

    void mostrarPedidosPendientes(UnidadProcesadora up);

    void mostrarPedidosTomados(DefaultTableModel dtm,Gestor gestor);
    
}
