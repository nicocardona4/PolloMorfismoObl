/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import dominio.Categoria;
import dominio.Insumo;
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
    
    private Collection<Insumo> insumos = new ArrayList<>();    


     Collection<ItemMenu> getItemDeCategoria(Categoria c) {
        Collection<ItemMenu> resultado = new ArrayList<ItemMenu>();
        for(ItemMenu im: menu.getInstancia().getItems())
        {
            if(im.getCategoria().equals(c))
            {
                resultado.add(im);
            }
        }
        return resultado;
    }
    
     Menu getMenu() {
        return menu;
    }
    
      void agregarCategoria(Categoria c) {
        categorias.add(c);
    }

     Collection<Categoria> getCategorias() {
        return categorias;
    }
    

    void agregarItem(ItemMenu im) {
        menu.getInstancia().getItems().add(im);
    }

    Collection<Insumo> getInsumos(){
    return insumos;
    }

    void agregarInsumo(Insumo insumo) {
        insumos.add(insumo);
    }
    
}
