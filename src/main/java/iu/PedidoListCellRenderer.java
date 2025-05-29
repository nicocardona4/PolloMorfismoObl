/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iu;

import dominio.Pedido;
import javax.swing.*;
import java.awt.*;

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
            setText(String.valueOf(value.getPedidoId())); // Muestro el id, luego obtengo mas info en la vista
                                                                //Otra opc. es tener un campo descripcion del pedido
                                                                //o un metodo descripcion
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
