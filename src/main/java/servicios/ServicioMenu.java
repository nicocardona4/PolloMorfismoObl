/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Categoria;
import dominio.ItemMenu;
import dominio.Menu;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nicoc
 */
public class ServicioMenu {

    
    private Menu menu;
    private Collection<Categoria> categorias = new ArrayList<>();
    private Collection<ItemMenu> items = new ArrayList<>();


    public Collection<ItemMenu> getItemDeCategoria(Categoria c) {
        Collection<ItemMenu> resultado = new ArrayList<ItemMenu>();
        for(ItemMenu im: items)
        {
            if(im.getCategoria().equals(c))
            {
                resultado.add(im);
            }
        }
        return resultado;
    }
    
    public Menu getMenu() {
        return menu;
    }
    
    public  void agregarCategoria(Categoria c) {
        categorias.add(c);
    }

    public Collection<Categoria> getCategorias() {
        return categorias;
    }
    

    void agregarItem(ItemMenu im) {
        items.add(im);
    }
    
}
