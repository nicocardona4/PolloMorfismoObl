/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu;

import dominio.Pedido;
import dominio.Servicio;
import javax.swing.*;
import java.awt.*;
import servicios.Fachada;

/**
 *
 * @author maurizio
 */
public class PedidoListCellRenderer extends JLabel implements ListCellRenderer<Pedido> {

    public PedidoListCellRenderer() {
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Pedido> list, Pedido value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            Fachada f = Fachada.getInstancia();
            Servicio s = value.getServicio();
            setText(String.valueOf(value.getItem().getNombre() + "- Cliente: " + s.getCliente().getNombreCompleto() + " - " + 
                    value.getFechaCreacion())); 
        }

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
    
}
