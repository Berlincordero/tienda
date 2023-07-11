
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    // metodo para consultar todas las categorias //el parametro define si se muestra solo las activas o todas 
    public List<Categoria> getCategorias(boolean activos);
    
    // se obtiene una categoria por su id
    public Categoria getCategoria(Categoria categoria);
    
    //Inserta: se inserta cuando el idCategoria esta vacio(valor 0 o null)
    //modifica: se modifica cuando el idCategoria no esta vacio 
    public void save(Categoria categoria); 
    
    // se elimina un resgiatro por su idCategoria
    public void delete(Categoria categoria);
}
